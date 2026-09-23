package e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class ContractTest {
    private static final Path ROOT = Paths.get("..", "..").toAbsolutePath().normalize();

    private static final List<String> EXPECTED = Arrays.asList(
            "POST /v1/audio/transcriptions", "POST /v1/analyze/diagnostic", "POST /v1/analyze/auditoriaRisco",
            "GET /v1/usage/log", "GET /v1/usage/by-key", "GET /v1/webhooks", "POST /v1/webhooks",
            "PUT /v1/webhooks/{webhook_id}", "DELETE /v1/webhooks/{webhook_id}",
            "GET /v1/email-alerts", "POST /v1/email-alerts", "PUT /v1/email-alerts/{alert_id}",
            "DELETE /v1/email-alerts/{alert_id}", "GET /api/version", "GET /v1/health", "HEAD /v1/health");

    @Test
    public void openapiTemOperacoesEsperadas() throws IOException {
        Path spec = ROOT.resolve("openapi.json");
        assertTrue(Files.isRegularFile(spec), "openapi.json ausente: " + spec);
        JsonObject root = JsonParser.parseString(Files.readString(spec, StandardCharsets.UTF_8)).getAsJsonObject();
        JsonObject paths = root.getAsJsonObject("paths");
        List<String> ops = new ArrayList<>();
        for (String path : paths.keySet()) {
            JsonObject methods = paths.getAsJsonObject(path);
            for (String m : methods.keySet()) {
                if (Arrays.asList("get", "post", "put", "delete", "patch", "head").contains(m)) {
                    ops.add(m.toUpperCase() + " " + path);
                }
            }
        }
        List<String> a = ops.stream().sorted().collect(Collectors.toList());
        List<String> b = EXPECTED.stream().sorted().collect(Collectors.toList());
        assertEquals(b, a);
    }

    @Test
    public void sdkCobre100pc() throws IOException {
        Path apiDir = ROOT.resolve("sdks/java/src/main/java/com/falaai/api");
        StringBuilder src = new StringBuilder();
        try (Stream<Path> files = Files.list(apiDir)) {
            for (Path f : files.filter(p -> p.toString().endsWith(".java")).collect(Collectors.toList())) {
                src.append(Files.readString(f, StandardCharsets.UTF_8));
            }
        }
        String s = src.toString();
        for (String p : Arrays.asList("/v1/usage/log", "/v1/webhooks", "/v1/email-alerts", "/api/version", "/v1/health", "/v1/analyze/auditoriaRisco")) {
            assertTrue(s.contains(p), "SDK nao cobre: " + p);
        }
    }

    @Test
    public void exemplosExistem() {
        List<String> files = Arrays.asList(
                "curl/transcribe.sh", "python/transcribe.py", "nodejs/transcribe.js",
                "curl/auditoria_risco.sh", "python/auditoria_risco.py", "nodejs/auditoria_risco.js",
                "curl/diagnostic.sh", "python/diagnostic.py", "nodejs/diagnostic.js");
        for (String f : files) {
            assertTrue(Files.isRegularFile(ROOT.resolve("app/static/examples").resolve(f)), "exemplo ausente: " + f);
        }
    }
}