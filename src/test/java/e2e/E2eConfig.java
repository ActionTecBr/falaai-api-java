package e2e;

import com.falaai.ApiClient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class E2eConfig {
    private static Map<String, String> env;

    private E2eConfig() {}

    private static synchronized Map<String, String> env() {
        if (env == null) {
            env = new HashMap<>();
            Path p = Paths.get("..", ".env.e2e");
            if (Files.isRegularFile(p)) {
                try {
                    for (String line : Files.readAllLines(p)) {
                        line = line.trim();
                        if (line.isEmpty() || line.startsWith("#") || !line.contains("=")) continue;
                        int i = line.indexOf('=');
                        env.put(line.substring(0, i).trim(), line.substring(i + 1).trim());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return env;
    }

    private static String get(String name) {
        String v = System.getenv(name);
        if (v != null && !v.isEmpty()) return v;
        return env().get(name);
    }

    public static String base() {
        String v = get("FALAAI_E2E_BASE");
        if (v == null) v = get("FALAAI_LOCAL_URL");
        if (v == null) v = "http://localhost:8002";
        return v;
    }

    public static String prod() {
        String v = get("FALAAI_PROD_URL");
        if (v == null) v = "https://api01-falaai.action.tec.br";
        return v;
    }

    public static String key() {
        return get("FALAAI_TEST_KEY");
    }

    public static String audio() {
        return get("FALAAI_E2E_AUDIO");
    }

    public static ApiClient client(String baseUrl) {
        return client(baseUrl, key());
    }

    public static ApiClient client(String baseUrl, String apiKey) {
        ApiClient c = new ApiClient();
        c.setBasePath(baseUrl);
        c.setBearerToken(apiKey);
        return c;
    }
}