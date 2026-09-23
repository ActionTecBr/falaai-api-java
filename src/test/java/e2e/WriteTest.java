package e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.falaai.ApiClient;
import com.falaai.ApiResponse;
import com.falaai.api.EmailAlertsApi;
import com.falaai.api.WebhooksApi;
import com.falaai.model.CreateEmailAlertRequest;
import com.falaai.model.CreateWebhookRequest;
import com.falaai.model.EmailAlertItem;
import com.falaai.model.EmailAlertListResponse;
import com.falaai.model.EmailAlertMessageResponse;
import com.falaai.model.EmailEvent;
import com.falaai.model.MessageResponse;
import com.falaai.model.UpdateEmailAlertRequest;
import com.falaai.model.UpdateWebhookRequest;
import com.falaai.model.WebhookEvent;
import com.falaai.model.WebhookItem;
import com.falaai.model.WebhookListResponse;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WriteTest {
    private static final String WNAME = "E2E Test Webhook";
    private static final String WURL = "https://e2e-falaai.invalid/hook";
    private static final String ANAME = "E2E Test Alert";
    private static final String AEMAIL = "e2e-test@falaai.invalid";

    private static void nonEmpty(String label, String v) {
        assertNotNull(v, label + " nulo");
        assertFalse(v.isEmpty(), label + " vazio");
    }

    private static void assertWebhookFull(WebhookItem w, String wid, String name, boolean active) {
        assertEquals(wid, w.getId());
        nonEmpty("user_id", w.getUserId());
        assertEquals(name, w.getName());
        assertEquals(WURL, w.getUrl());
        nonEmpty("secret", w.getSecret());
        assertNotNull(w.getEvents());
        assertEquals(2, w.getEvents().size());
        assertEquals(active, w.getActive());
        assertNotNull(w.getRetryEnabled());
        assertNotNull(w.getFailureCount());
        nonEmpty("created_at", w.getCreatedAt());
        nonEmpty("updated_at", w.getUpdatedAt());
    }

    private static void assertAlertFull(EmailAlertItem a, String aid, String name, boolean active) {
        assertEquals(aid, a.getId());
        nonEmpty("user_id", a.getUserId());
        assertEquals(name, a.getName());
        assertEquals(AEMAIL, a.getEmail());
        assertNotNull(a.getEvents());
        assertEquals(2, a.getEvents().size());
        assertEquals(active, a.getActive());
        nonEmpty("created_at", a.getCreatedAt());
        nonEmpty("updated_at", a.getUpdatedAt());
    }

    private static void cleanupWebhooks(WebhooksApi api) throws Exception {
        WebhookListResponse list = api.listWebhooksV1WebhooksGetWithHttpInfo(1, 100).getData();
        for (WebhookItem w : list.getData()) {
            if (WURL.equals(w.getUrl())) api.deleteWebhookV1WebhooksWebhookIdDeleteWithHttpInfo(w.getId());
        }
    }

    private static void cleanupAlerts(EmailAlertsApi api) throws Exception {
        EmailAlertListResponse list = api.listEmailAlertsV1EmailAlertsGetWithHttpInfo(1, 100).getData();
        for (EmailAlertItem a : list.getData()) {
            if (AEMAIL.equals(a.getEmail())) api.deleteEmailAlertV1EmailAlertsAlertIdDeleteWithHttpInfo(a.getId());
        }
    }

    @Test
    public void webhooksCrud() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        WebhooksApi api = new WebhooksApi(c);
        cleanupWebhooks(api);

        CreateWebhookRequest body = new CreateWebhookRequest()
                .name(WNAME).url(WURL).events(Arrays.asList(WebhookEvent.CREDITS_LOW, WebhookEvent.PAYMENT_FAILED));
        ApiResponse<WebhookItem> cr = api.createWebhookV1WebhooksPostWithHttpInfo(body);
        E2eLogger.log("webhooks_create", "POST", "/v1/webhooks", body, cr.getData(), "HTTP " + cr.getStatusCode(), cr.getStatusCode());
        assertEquals(200, cr.getStatusCode());
        String wid = cr.getData().getId();
        assertWebhookFull(cr.getData(), wid, WNAME, true);

        UpdateWebhookRequest ub = new UpdateWebhookRequest().name(WNAME + " (updated)").active(false);
        ApiResponse<MessageResponse> ur = api.updateWebhookV1WebhooksWebhookIdPutWithHttpInfo(wid, ub);
        E2eLogger.log("webhooks_update", "PUT", "/v1/webhooks/" + wid, ub, ur.getData(), "HTTP " + ur.getStatusCode(), ur.getStatusCode());
        assertEquals(200, ur.getStatusCode());
        assertEquals("updated", ur.getData().getMessage());

        WebhookListResponse list = api.listWebhooksV1WebhooksGetWithHttpInfo(1, 100).getData();
        WebhookItem row = null;
        for (WebhookItem w : list.getData()) if (wid.equals(w.getId())) row = w;
        assertNotNull(row);
        assertWebhookFull(row, wid, WNAME + " (updated)", false);

        ApiResponse<MessageResponse> dr = api.deleteWebhookV1WebhooksWebhookIdDeleteWithHttpInfo(wid);
        E2eLogger.log("webhooks_delete", "DELETE", "/v1/webhooks/" + wid, null, dr.getData(), "HTTP " + dr.getStatusCode(), dr.getStatusCode());
        assertEquals(200, dr.getStatusCode());
        assertEquals("deleted", dr.getData().getMessage());

        WebhookListResponse list2 = api.listWebhooksV1WebhooksGetWithHttpInfo(1, 100).getData();
        for (WebhookItem w : list2.getData()) assertFalse(wid.equals(w.getId()), "webhook ainda existe apos delete");
    }

    @Test
    public void emailAlertsCrud() throws Exception {
        ApiClient c = E2eConfig.client(E2eConfig.base());
        EmailAlertsApi api = new EmailAlertsApi(c);
        cleanupAlerts(api);

        CreateEmailAlertRequest body = new CreateEmailAlertRequest()
                .name(ANAME).email(AEMAIL).events(Arrays.asList(EmailEvent.CREDITS_LOW, EmailEvent.PAYMENT_FAILED));
        ApiResponse<EmailAlertItem> cr = api.createEmailAlertV1EmailAlertsPostWithHttpInfo(body);
        E2eLogger.log("email_alerts_create", "POST", "/v1/email-alerts", body, cr.getData(), "HTTP " + cr.getStatusCode(), cr.getStatusCode());
        assertEquals(200, cr.getStatusCode());
        String aid = cr.getData().getId();
        assertAlertFull(cr.getData(), aid, ANAME, true);

        UpdateEmailAlertRequest ub = new UpdateEmailAlertRequest().name(ANAME + " (updated)").active(false);
        ApiResponse<EmailAlertMessageResponse> ur = api.updateEmailAlertV1EmailAlertsAlertIdPutWithHttpInfo(aid, ub);
        E2eLogger.log("email_alerts_update", "PUT", "/v1/email-alerts/" + aid, ub, ur.getData(), "HTTP " + ur.getStatusCode(), ur.getStatusCode());
        assertEquals(200, ur.getStatusCode());
        assertEquals("updated", ur.getData().getMessage());

        EmailAlertListResponse list = api.listEmailAlertsV1EmailAlertsGetWithHttpInfo(1, 100).getData();
        EmailAlertItem row = null;
        for (EmailAlertItem a : list.getData()) if (aid.equals(a.getId())) row = a;
        assertNotNull(row);
        assertAlertFull(row, aid, ANAME + " (updated)", false);

        ApiResponse<EmailAlertMessageResponse> dr = api.deleteEmailAlertV1EmailAlertsAlertIdDeleteWithHttpInfo(aid);
        E2eLogger.log("email_alerts_delete", "DELETE", "/v1/email-alerts/" + aid, null, dr.getData(), "HTTP " + dr.getStatusCode(), dr.getStatusCode());
        assertEquals(200, dr.getStatusCode());
        assertEquals("deleted", dr.getData().getMessage());

        EmailAlertListResponse list2 = api.listEmailAlertsV1EmailAlertsGetWithHttpInfo(1, 100).getData();
        for (EmailAlertItem a : list2.getData()) assertFalse(aid.equals(a.getId()), "alert ainda existe apos delete");
    }
}