# FalaAI API - Java SDK

[![version](https://img.shields.io/badge/version-1.21.47-blue)](https://central.sonatype.com/artifact/io.github.actiontecbr/falaai-api)
[![license](https://img.shields.io/badge/license-MIT-green)](https://github.com/ActionTecBr/falaai-api-java/blob/main/LICENSE)
[![build](https://github.com/ActionTecBr/falaai-api-java/actions/workflows/ci.yml/badge.svg)](https://github.com/ActionTecBr/falaai-api-java/actions/workflows/ci.yml)

Official Java SDK for the **FalaAI API**.

## What is FalaAI API?

FalaAI API turns conversations into auditable business intelligence, in three steps:

1. **Transcribe** - audio (calls, voice notes, meetings) to text, with speaker separation.
2. **Diagnose** - summary, reason, recommended action, topic and sentiment per conversation.
3. **Audit compliance** - risk score and violations against **COPC CX** and **ISO 18295-1**.

It works with phone calls, WhatsApp, Telegram, chat, email, PDF and images.
Three REST endpoints, one API key, no setup.

## Who it's for

| Role | What they get |
| --- | --- |
| **Contact Center / Quality** | Audit 100% of conversations instead of a sample |
| **Compliance / Legal** | Forensic, auditable evidence for audits and disputes |
| **CX / Operations** | Risk score, sentiment and reason for every conversation |
| **Developers** | One typed SDK, three REST endpoints, one API key |
| **Data / BI** | Clean, typed JSON ready for your database or BI tool |

## Install

```xml
<dependency>
  <groupId>io.github.actiontecbr</groupId>
  <artifactId>falaai-api</artifactId>
  <version>1.21.47</version>
</dependency>
```

## Quick start

```java
import com.falaai.ApiClient;
import com.falaai.api.SpeechApi;
import com.falaai.model.TranscriptionResponse;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath("https://api01-falaai.action.tec.br");
        client.setBearerToken("fai_xxxxxx");

        SpeechApi speech = new SpeechApi(client);

        TranscriptionResponse res = speech
            .createTranscriptionV1AudioTranscriptionsPostWithHttpInfo(
                new File("call.mp3"), "falaai-transcribe-1", "pt", null)
            .getData();

        System.out.println(res.getText());
    }
}
```

## Use cases

- Call and voice-note **transcription** with speaker separation
- **Contact center quality assurance (QA)** automation
- **Compliance auditing** against **COPC CX** and **ISO 18295-1**
- **Risk detection** - churn risk, legal threats, escalation
- **WhatsApp, Telegram and chat** conversation analysis
- **CRM and help desk** enrichment
- **LGPD**-aware handling of customer conversations

## Where it fits

Common Java stacks in contact center, CRM and help desk - if you build on any of these, the SDK drops in:

ServiceNow - SAP Service Cloud - Oracle CX - WhatsApp Business Platform

> Product names are trademarks of their respective owners, listed as common stacks in this ecosystem. No partnership is implied.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/v1/audio/transcriptions` | Audio to text, with speaker separation |
| `POST` | `/v1/analyze/diagnostic` | Conversation analysis - summary, reason, action, topic, sentiment |
| `POST` | `/v1/analyze/auditoriaRisco` | Compliance audit - risk score and violations |

All endpoints require `Authorization: Bearer fai_xxxxxx`.
Full reference: <https://api01-falaai.action.tec.br/docs>

## Links

- **Product:** <https://falaai.action.tec.br/api>
- **API reference:** <https://api01-falaai.action.tec.br/docs>
- **Get an API key:** <https://falaai.action.tec.br/api/auth>
- **Package (Maven Central):** <https://central.sonatype.com/artifact/io.github.actiontecbr/falaai-api>
- **Source:** <https://github.com/ActionTecBr/falaai-api-java>

## License

MIT (c) 2026 Action Tec Br - see [LICENSE](LICENSE).
