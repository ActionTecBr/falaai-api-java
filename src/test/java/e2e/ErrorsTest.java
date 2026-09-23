package e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;

public class ErrorsTest {
    private static HttpResponse<String> post(String path, String json) throws Exception {
        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create(E2eConfig.base() + path))
                .header("Authorization", "Bearer " + E2eConfig.key())
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        return http.send(req, HttpResponse.BodyHandlers.ofString());
    }

    private static HttpResponse<String> get(String path, String auth) throws Exception {
        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create(E2eConfig.base() + path))
                .header("Authorization", auth)
                .GET().build();
        return http.send(req, HttpResponse.BodyHandlers.ofString());
    }

    @Test
    public void invalidKey401() throws Exception {
        HttpResponse<String> r = get("/v1/usage/log?page=1&limit=1", "Bearer fai_chave_invalida_000");
        E2eLogger.log("errors_401", "GET", "/v1/usage/log", null, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(401, r.statusCode());
    }

    @Test
    public void diagnosticMissing422() throws Exception {
        String body = "{\"language\":\"pt-BR\",\"dialog\":\"Speaker 1: ola\"}";
        HttpResponse<String> r = post("/v1/analyze/diagnostic", body);
        E2eLogger.log("errors_422_diag", "POST", "/v1/analyze/diagnostic", body, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(422, r.statusCode());
    }

    @Test
    public void auditoriaMissing422() throws Exception {
        String body = "{\"language\":\"pt-BR\",\"dialog\":\"Speaker 1: ola\"}";
        HttpResponse<String> r = post("/v1/analyze/auditoriaRisco", body);
        E2eLogger.log("errors_422_aud", "POST", "/v1/analyze/auditoriaRisco", body, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(422, r.statusCode());
    }

    @Test
    public void extraForbidden422() throws Exception {
        String body = "{\"dialog\":\"Speaker 1: ola\",\"language\":\"pt-BR\",\"response_language\":\"pt-BR\",\"duration_seconds\":10,\"threshold_multiplier\":1}";
        HttpResponse<String> r = post("/v1/analyze/auditoriaRisco", body);
        E2eLogger.log("errors_422_extra", "POST", "/v1/analyze/auditoriaRisco", body, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(422, r.statusCode());
    }

    @Test
    public void auditoriaLanguage400() throws Exception {
        String body = "{\"dialog\":\"Speaker 1: ola\",\"language\":\"xx\",\"response_language\":\"pt-BR\",\"duration_seconds\":10}";
        HttpResponse<String> r = post("/v1/analyze/auditoriaRisco", body);
        E2eLogger.log("errors_400_aud", "POST", "/v1/analyze/auditoriaRisco", body, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(400, r.statusCode());
    }

    @Test
    public void diagnosticLanguage400() throws Exception {
        String body = "{\"dialog\":\"Speaker 1: ola\",\"language\":\"xx\",\"duration_seconds\":10}";
        HttpResponse<String> r = post("/v1/analyze/diagnostic", body);
        E2eLogger.log("errors_400_diag", "POST", "/v1/analyze/diagnostic", body, r.body(), "HTTP " + r.statusCode(), r.statusCode());
        assertEquals(400, r.statusCode());
    }
}