import com.falaai.ApiClient;
import com.falaai.api.WhatsappApi;
import java.io.File;

public class WhatsappExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath(System.getenv("FALAAI_BASE_URL"));
        client.setBearerToken(System.getenv("FALAAI_API_KEY"));
        WhatsappApi whatsappApi = new WhatsappApi(client);

        // REQUIRED: file (.zip/.txt export), start, end, timezone, date_format + Authorization
        // OPTIONAL: gap_minutes (default 720) | min_messages (default 2) | chars_per_minute (default 800) | client_reference_id
        var result = whatsappApi.extractConversationsV1WhatsappExtractConversationsPost(
            new File("demo_whatsapp.zip"),
            "2024-01-01T00:00:00",
            "2024-12-31T23:59:59",
            "-3",
            "day_first",
            new java.math.BigDecimal(720),
            2,
            new java.math.BigDecimal(800),
            null
        );

        System.out.println(result);
    }
}
