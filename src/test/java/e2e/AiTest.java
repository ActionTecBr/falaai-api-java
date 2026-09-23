package e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.falaai.ApiClient;
import com.falaai.ApiResponse;
import com.falaai.api.AnalysisApi;
import com.falaai.api.SpeechApi;
import com.falaai.model.AudioEvent;
import com.falaai.model.AudioInputMeta;
import com.falaai.model.AuditoriaRiscoRequest;
import com.falaai.model.AuditoriaRiscoV2;
import com.falaai.model.AuditoriaRiscoV2Response;
import com.falaai.model.DiagnosticAudioEvent;
import com.falaai.model.DiagnosticRequest;
import com.falaai.model.DiagnosticResponse;
import com.falaai.model.Participant;
import com.falaai.model.TranscriptionResponse;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AiTest {
    private static void nonEmpty(String label, String v) {
        assertNotNull(v, label + " nulo");
        assertFalse(v.isEmpty(), label + " vazio");
    }

    @Test
    public void aiChain() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.prod());
        SpeechApi sp = new SpeechApi(c);
        AnalysisApi an = new AnalysisApi(c);

        File file = new File(E2eConfig.audio());
        ApiResponse<TranscriptionResponse> trr = sp.createTranscriptionV1AudioTranscriptionsPostWithHttpInfo(
                file, "falaai-transcribe-1", "pt", "e2e-call-2026-09-22-001");
        TranscriptionResponse tr = trr.getData();
        E2eLogger.log("transcriptions", "POST", "/v1/audio/transcriptions",
                "file=analise_25s.mp3 model=falaai-transcribe-1 language=pt client_reference_id=e2e-call-2026-09-22-001",
                tr, "HTTP " + trr.getStatusCode(), trr.getStatusCode());
        assertEquals(200, trr.getStatusCode());
        nonEmpty("id", tr.getId());
        assertNotNull(tr.getObject());
        nonEmpty("model", tr.getModel());
        nonEmpty("filename", tr.getFilename());
        nonEmpty("processed_at", tr.getProcessedAt());
        assertNotNull(tr.getUsage().getAudioSeconds());
        assertTrue(tr.getUsage().getAudioSeconds().compareTo(BigDecimal.ZERO) > 0);
        assertNotNull(tr.getUsage().getCreditsConsumed());
        assertNotNull(tr.getUsage().getProcessingMs());
        nonEmpty("language", tr.getLanguage());
        assertNotNull(tr.getDurationSeconds());
        assertTrue(tr.getDurationSeconds().compareTo(BigDecimal.ZERO) > 0);
        nonEmpty("text", tr.getText());
        nonEmpty("dialog", tr.getDialog());
        assertNotNull(tr.getAudioEvents());
        for (AudioEvent ev : tr.getAudioEvents()) {
            nonEmpty("event", ev.getEvent());
            assertNotNull(ev.getStartS());
            assertNotNull(ev.getEndS());
            assertNotNull(ev.getDurationS());
            nonEmpty("formatted_timestamp", ev.getFormattedTimestamp());
        }
        assertNotNull(tr.getEventTypes());
        assertNotNull(tr.getWordCount());
        assertTrue(tr.getWordCount() > 0);
        AudioInputMeta in = tr.getInput();
        assertNotNull(in.getDurationS());
        nonEmpty("input.original_format", in.getOriginalFormat());
        nonEmpty("input.codec", in.getCodec());
        assertNotNull(in.getSampleRate());
        assertNotNull(in.getChannels());

        List<DiagnosticAudioEvent> events = new ArrayList<>();
        for (AudioEvent ev : tr.getAudioEvents()) {
            events.add(new DiagnosticAudioEvent()
                    .event(ev.getEvent()).startS(ev.getStartS()).endS(ev.getEndS())
                    .durationS(ev.getDurationS()).formattedTimestamp(ev.getFormattedTimestamp()));
        }

        DiagnosticRequest db = new DiagnosticRequest()
                .model("falaai-diagnostic-1").dialog(tr.getDialog()).language("pt-BR")
                .durationSeconds(tr.getDurationSeconds()).text(tr.getText())
                .audioEvents(events)
                .clientReferenceId("e2e-diag-2026-09-22-001");
        ApiResponse<DiagnosticResponse> dr = an.createDiagnosticV1AnalyzeDiagnosticPostWithHttpInfo(db);
        DiagnosticResponse d = dr.getData();
        E2eLogger.log("diagnostic", "POST", "/v1/analyze/diagnostic", db, d, "HTTP " + dr.getStatusCode(), dr.getStatusCode());
        assertEquals(200, dr.getStatusCode());
        nonEmpty("id", d.getId());
        nonEmpty("response_language", d.getResponseLanguage());
        assertEquals("analysis", d.getObject());
        assertNotNull(d.getAnalysis().getDialogueSummary());
        assertNotNull(d.getAnalysis().getContactReason());
        assertNotNull(d.getAnalysis().getIdentifiedAction());
        assertNotNull(d.getAnalysis().getIdentifiedLabel());
        assertNotNull(d.getAnalysis().getSentiment());
        assertNotNull(d.getUsage().getCharacters());
        assertNotNull(d.getUsage().getCreditsConsumed());
        assertNotNull(d.getUsage().getProcessingMs());

        AuditoriaRiscoRequest ab = new AuditoriaRiscoRequest()
                .model("falaai-auditoria-risco-1").dialog(tr.getDialog()).language("pt-BR")
                .responseLanguage("pt-BR").durationSeconds(tr.getDurationSeconds()).text(tr.getText())
                .audioEvents(events)
                .callDirection(AuditoriaRiscoRequest.CallDirectionEnum.INBOUND)
                .participants(Arrays.asList(
                        new Participant().interlocutor("Speaker 1").name("Mateus").role(Participant.RoleEnum.AGENT),
                        new Participant().interlocutor("Speaker 2").name("Cliente").role(Participant.RoleEnum.CLIENT)))
                .responseFormat("v2").clientReferenceId("e2e-aud-2026-09-22-001");
        ApiResponse<AuditoriaRiscoV2Response> ar = an.createAuditoriaRiscoV1AnalyzeAuditoriaRiscoPostWithHttpInfo(ab);
        AuditoriaRiscoV2 pub = ar.getData().getResponse();
        E2eLogger.log("auditoriaRisco", "POST", "/v1/analyze/auditoriaRisco", ab, ar.getData(), "HTTP " + ar.getStatusCode(), ar.getStatusCode());
        assertEquals(200, ar.getStatusCode());
        nonEmpty("meta.id", pub.getMeta().getId());
        assertNotNull(pub.getMeta().getUsage().getCharacters());
        assertNotNull(pub.getMeta().getUsage().getCreditsConsumed());
        assertNotNull(pub.getMeta().getUsage().getProcessingMs());
        assertNotNull(pub.getParticipants());
        assertNotNull(pub.getVerdict());
        assertNotNull(pub.getScores());
        assertNotNull(pub.getDetections());
        assertNotNull(pub.getAnalysis());
        assertNotNull(pub.getTimeline());
        assertNotNull(pub.getAudioEventModel());
        assertNotNull(pub.getCategoriesSummary());
        assertNotNull(pub.getIndexer());
        assertNotNull(pub.getSummary());
        assertNotNull(pub.getAcoesI18n());
        assertNotNull(pub.getAuditDecisions());
        assertNotNull(pub.getScoringExplanation());
        assertNotNull(pub.getHtmlReport());
    }
}