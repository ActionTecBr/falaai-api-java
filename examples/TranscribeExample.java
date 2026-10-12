import com.falaai.ApiClient;
import com.falaai.api.SpeechApi;

import java.io.File;

public class TranscribeExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath(System.getenv("FALAAI_BASE_URL"));
        client.setBearerToken(System.getenv("FALAAI_API_KEY"));
        client.setReadTimeout(300000);

        SpeechApi sp = new SpeechApi(client);

        String language = "pt";
        String clientReferenceId = "20260927140800000-aud";

// REQUIRED: file (audio) + Authorization (fai_ key)
// OPTIONAL (server defaults): model -> falaai-transcribe-1 | language -> pt | client_reference_id -> (empty)
        var transcription = sp.createTranscriptionV1AudioTranscriptionsPost(
                new File("demo_callcenter.mp3"), "falaai-transcribe-1", language, clientReferenceId);

        System.out.println(new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(transcription));
    }
}
