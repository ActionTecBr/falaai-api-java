import com.falaai.ApiClient;
import com.falaai.api.HealthApi;

public class HealthExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath(System.getenv("FALAAI_BASE_URL"));

        HealthApi healthApi = new HealthApi(client);
        System.out.println(new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(healthApi.healthCheck()));

        healthApi.healthCheckHead();
    }
}
