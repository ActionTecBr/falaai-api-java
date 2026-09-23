# FalaAI API — Java SDK

Official Java SDK for the **FalaAI API** — AI-powered call transcription, diagnosis and compliance auditing.

## Install

### Maven

```xml
<dependency>
    <groupId>com.falaai</groupId>
    <artifactId>falaai-api</artifactId>
    <version>1.21.47</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.falaai:falaai-api:1.21.47'
```

## Quick start

```java
import com.falaai.ApiClient;
import com.falaai.ApiResponse;
import com.falaai.api.HealthApi;
import com.falaai.model.HealthResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath("https://api01-falaai.action.tec.br");
        client.setBearerToken("fai_xxx");

        ApiResponse<HealthResponse> res = new HealthApi(client).healthCheckWithHttpInfo();
        System.out.println(res.getData().getStatus() + " " + res.getStatusCode());
    }
}
```

## Endpoints

| Method | Path | Description |
|---|---|---|
| POST | `/v1/audio/transcriptions` | Audio to text (diarization, audio events) |
| POST | `/v1/analyze/diagnostic` | Conversation analysis |
| POST | `/v1/analyze/auditoriaRisco` | Compliance audit (risk) |
| GET | `/v1/usage/log` | Usage log |
| GET | `/v1/usage/by-key` | Usage grouped by API key |
| GET/POST | `/v1/webhooks` | List / create webhooks |
| PUT/DELETE | `/v1/webhooks/{webhook_id}` | Update / delete webhook |
| GET/POST | `/v1/email-alerts` | List / create email alerts |
| PUT/DELETE | `/v1/email-alerts/{alert_id}` | Update / delete email alert |
| GET | `/api/version` | API version |
| GET/HEAD | `/v1/health` | Health check |

## Authentication

Authenticated endpoints require an API key in the `Authorization` header:

```
Authorization: Bearer fai_xxx
```

Get your API key at [falaai.action.tec.br/api](https://falaai.action.tec.br/api).

## Build & test

```bash
mvn clean test
```

An end-to-end suite (19 tests) lives in `src/test/java/e2e/` and runs against the live API:

```bash
FALAAI_E2E_BASE=https://api01-falaai.action.tec.br FALAAI_TEST_KEY=fai_xxx mvn test
```

## License

[MIT](LICENSE) © Action Tec Br