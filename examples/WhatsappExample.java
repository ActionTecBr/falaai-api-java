import com.falaai.ApiClient;
import com.falaai.api.WhatsappApi;
import java.io.File;

public class WhatsappExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath(System.getenv("FALAAI_BASE_URL"));
        client.setBearerToken(System.getenv("FALAAI_API_KEY"));
        client.setReadTimeout(300000);
        WhatsappApi whatsappApi = new WhatsappApi(client);

        // REQUIRED: file (.zip/.txt export), start, end, timezone, date_format + Authorization
        // OPTIONAL: gap_minutes (default 720) | min_messages (default 2) | client_reference_id
        var result = whatsappApi.extractConversationsV1WhatsappExtractConversationsPost(
            new File("demo_whatsapp.zip"),
            "2024-01-01 00:00",
            "2024-12-31 23:59",
            "-3",
            "day_first",
            new java.math.BigDecimal(720),
            2,
            true,
            true,
            null
        );

        System.out.println(new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(result));
    }
}
