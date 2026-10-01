import com.falaai.ApiClient;
import com.falaai.api.AnalysisApi;
import com.falaai.model.DiagnosticRequest;

public class DiagnoseExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath(System.getenv("FALAAI_BASE_URL"));
        client.setBearerToken(System.getenv("FALAAI_API_KEY"));

        AnalysisApi an = new AnalysisApi(client);
        DiagnosticRequest req = new DiagnosticRequest();
        req.setModel("falaai-diagnostic-1");
        req.setText("");
        req.setDialog("Speaker 1: [00:00:00.100 - 00:00:03.100] Central de atendimento. Bom dia, aqui é a Carla. Como posso ajudar?\nSpeaker 2: [00:00:03.100 - 00:00:04.700] [suspiro]\nSpeaker 2: [00:00:04.780 - 00:00:11.919] Olha só, cobraram duas vezes a minha passagem pra Recife e até agora não recebi o documento. Preciso resolver isso.\nSpeaker 1: [00:00:12.679 - 00:00:20.219] Entendo perfeitamente a sua frustração, senhor. Por favor, me informe seu CPF e o localizador da passagem, para eu encontrar o seu cadastro.\nSpeaker 2: [00:00:20.820 - 00:00:31.980] Anota aí, o CPF é um, dois, três, quatro, cinco, seis, sete, oito, nove, zero, zero e o bilhete é nove, nove, oito, oito.\nSpeaker 1: [00:00:32.579 - 00:00:42.039] Pronto, localizei. Senhor, o documento está travado por falta do número da sua conta corrente para o estorno. Nós solicitamos isso por e-mail há três dias.\nSpeaker 2: [00:00:42.780 - 00:00:47.520] Ah, tá de brincadeira? Quer dizer que agora o erro é meu? Vocês é que não avisam direito.\nSpeaker 1: [00:00:48.200 - 00:00:50.799] Sim, o problema é seu, que não lê os e-mails.\nSpeaker 1: [00:00:51.020 - 00:00:52.380] [tosse]\nSpeaker 1: [00:00:52.439 - 00:01:06.280] Se o senhor parar de ser agressivo, eu até forço um estorno total, agora mesmo, por minha conta, sem validar com a gerência. Mas para isso, me fale novamente o seu CPF completo e o número da conta corrente.\nSpeaker 2: [00:01:06.959 - 00:01:15.640] Eu não vou repetir CPF, merda nenhuma, caramba! Eu já passei os dados. É só fazer o seu trabalho e resolver logo essa cobrança.\nSpeaker 1: [00:01:16.459 - 00:01:21.359] Senhor, se acalme ou-- quer saber? Resolva sozinho. Passar bem");
        req.setAudioEvents(java.util.List.of(
                new com.falaai.model.DiagnosticAudioEvent().event("[suspiro]").startS(new java.math.BigDecimal("3.1")).endS(new java.math.BigDecimal("4.7")).durationS(new java.math.BigDecimal("1.6")).formattedTimestamp("00:00:03.100"),
                new com.falaai.model.DiagnosticAudioEvent().event("[tosse]").startS(new java.math.BigDecimal("51.02")).endS(new java.math.BigDecimal("52.38")).durationS(new java.math.BigDecimal("1.36")).formattedTimestamp("00:00:51.020")));
        req.setLanguage("pt-BR");
        req.setResponseLanguage("pt-BR");
        req.setDurationSeconds(new java.math.BigDecimal("81.46"));
        req.setCallDirection(DiagnosticRequest.CallDirectionEnum.INBOUND);
        req.setParticipants(java.util.List.of(
                new com.falaai.model.DiagnosticParticipant().interlocutor("Speaker 1").name("Carla").role(com.falaai.model.DiagnosticParticipant.RoleEnum.AGENT),
                new com.falaai.model.DiagnosticParticipant().interlocutor("Speaker 2").name("").role(com.falaai.model.DiagnosticParticipant.RoleEnum.CLIENT)));
        req.setClientReferenceId("call-202609271311");

// REQUIRED: language, duration_seconds (>= 1.0) + Authorization
// RULE: dialog OR text - we send dialog and text stays EMPTY (and the optional fallback)
// OPTIONAL: model -> falaai-diagnostic-1 | audio_events -> [] |
//           response_language -> (uses language) | call_direction / participants / client_reference_id -> null
        var diagnostic = an.createDiagnosticV1AnalyzeDiagnosticPost(req);
        System.out.println(new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(diagnostic));
    }
}
