package e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.falaai.ApiClient;
import com.falaai.ApiResponse;
import com.falaai.api.EmailAlertsApi;
import com.falaai.api.HealthApi;
import com.falaai.api.UsageApi;
import com.falaai.api.VersionApi;
import com.falaai.api.WebhooksApi;
import com.falaai.model.EmailAlertItem;
import com.falaai.model.EmailAlertListResponse;
import com.falaai.model.HealthResponse;
import com.falaai.model.UsageByKeyItem;
import com.falaai.model.UsageLogItem;
import com.falaai.model.UsageLogResponse;
import com.falaai.model.VersionResponse;
import com.falaai.model.WebhookItem;
import com.falaai.model.WebhookListResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ReadTest {
    private static void nonEmpty(String label, String v) {
        assertNotNull(v, label + " nulo");
        assertFalse(v.isEmpty(), label + " vazio");
    }

    @Test
    public void healthGet() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<HealthResponse> r = new HealthApi(c).healthCheckWithHttpInfo();
        HealthResponse p = r.getData();
        E2eLogger.log("health_get", "GET", "/v1/health", null, p, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertEquals("ok", p.getStatus());
        nonEmpty("version", p.getVersion());
        assertNotNull(p.getUptimeSeconds());
        assertTrue(p.getUptimeSeconds() >= 0);
        assertNotNull(p.getDatabase());
        nonEmpty("phase", p.getPhase());
        nonEmpty("launch_date", p.getLaunchDate());
    }

    @Test
    public void healthHead() throws Exception {
        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create(E2eConfig.base() + "/v1/health"))
                .method("HEAD", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<Void> res = http.send(req, HttpResponse.BodyHandlers.discarding());
        E2eLogger.log("health_head", "HEAD", "/v1/health", null, "status=" + res.statusCode(), "HTTP " + res.statusCode(), res.statusCode());
        assertEquals(200, res.statusCode());
    }

    @Test
    public void version() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<VersionResponse> r = new VersionApi(c).getVersionApiVersionGetWithHttpInfo();
        VersionResponse p = r.getData();
        E2eLogger.log("version", "GET", "/api/version", null, p, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertEquals("FalaAI API", p.getService());
        nonEmpty("version", p.getVersion());
        nonEmpty("deploy_date", p.getDeployDate());
    }

    @Test
    public void usageLog() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<UsageLogResponse> r = new UsageApi(c).getUsageLogV1UsageLogGetWithHttpInfo(1, 5, null);
        UsageLogResponse p = r.getData();
        E2eLogger.log("usage_log", "GET", "/v1/usage/log", "page=1 limit=5", p, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertEquals(1, p.getPage());
        assertEquals(5, p.getLimit());
        assertNotNull(p.getData());
        for (UsageLogItem it : p.getData()) {
            nonEmpty("id", it.getId());
            nonEmpty("endpoint", it.getEndpoint());
            assertNotNull(it.getCreditsCost());
            nonEmpty("status", it.getStatus());
            assertNotNull(it.getErrorsCount());
            nonEmpty("created_at", it.getCreatedAt());
        }
    }

    @Test
    public void usageByKey() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<List<UsageByKeyItem>> r = new UsageApi(c).getUsageByKeyV1UsageByKeyGetWithHttpInfo(null);
        List<UsageByKeyItem> data = r.getData();
        E2eLogger.log("usage_by_key", "GET", "/v1/usage/by-key", null, data, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertNotNull(data);
        for (UsageByKeyItem it : data) {
            nonEmpty("key_id", it.getKeyId());
            assertNotNull(it.getKeyName());
            assertNotNull(it.getTotalCredits());
            assertNotNull(it.getRequestCount());
        }
    }

    @Test
    public void webhooksList() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<WebhookListResponse> r = new WebhooksApi(c).listWebhooksV1WebhooksGetWithHttpInfo(1, 5);
        WebhookListResponse p = r.getData();
        E2eLogger.log("webhooks_list", "GET", "/v1/webhooks", "page=1 limit=5", p, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertEquals(1, p.getPage());
        assertEquals(5, p.getLimit());
        assertNotNull(p.getData());
        for (WebhookItem w : p.getData()) {
            nonEmpty("id", w.getId());
            nonEmpty("user_id", w.getUserId());
            assertNotNull(w.getName());
            nonEmpty("url", w.getUrl());
            assertNotNull(w.getSecret());
            assertNotNull(w.getEvents());
            assertNotNull(w.getActive());
            assertNotNull(w.getRetryEnabled());
            assertNotNull(w.getFailureCount());
            nonEmpty("created_at", w.getCreatedAt());
            nonEmpty("updated_at", w.getUpdatedAt());
        }
    }

    @Test
    public void emailAlertsList() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        ApiResponse<EmailAlertListResponse> r = new EmailAlertsApi(c).listEmailAlertsV1EmailAlertsGetWithHttpInfo(1, 5);
        EmailAlertListResponse p = r.getData();
        E2eLogger.log("email_alerts_list", "GET", "/v1/email-alerts", "page=1 limit=5", p, "HTTP " + r.getStatusCode(), r.getStatusCode());
        assertEquals(200, r.getStatusCode());
        assertEquals(1, p.getPage());
        assertEquals(5, p.getLimit());
        assertNotNull(p.getData());
        for (EmailAlertItem a : p.getData()) {
            nonEmpty("id", a.getId());
            nonEmpty("user_id", a.getUserId());
            assertNotNull(a.getName());
            nonEmpty("email", a.getEmail());
            assertNotNull(a.getEvents());
            assertNotNull(a.getActive());
            nonEmpty("created_at", a.getCreatedAt());
            nonEmpty("updated_at", a.getUpdatedAt());
        }
    }
}