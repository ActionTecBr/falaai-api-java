

# DiagnosticRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**model** | **String** | Analysis model. Always &#39;falaai-diagnostic-1&#39; |  [optional] |
|**text** | **String** | Plain transcript (fallback if dialog is empty). At least one of &#39;dialog&#39; or &#39;text&#39; required. Max 300,000 characters |  [optional] |
|**dialog** | **String** | Diarized transcript with speaker turns. PRIMARY source. At least one of &#39;dialog&#39; or &#39;text&#39; required. Speaker labels accepted (any case): &#39;Speaker N&#39;, &#39;Interlocutor N&#39;, &#39;Hablante N&#39;, &#39;Locutor N&#39;, &#39;Orador N&#39; (space or underscore). Normalized internally to &#39;Speaker N&#39; in the response. Max 300,000 characters |  [optional] |
|**audioEvents** | [**List&lt;DiagnosticAudioEvent&gt;**](DiagnosticAudioEvent.md) | Detected audio events with timestamps (required when using dialog) |  [optional] |
|**language** | **String** | Transcript language. Required. Accepted: en-US, pt-BR, es-ES, es-MX, fr-FR, de-DE, it-IT, pt-PT, zh-CN, ja-JP, ko-KR, ar-SA, hi-IN, ru-RU, id-ID, tr-TR, nl-NL, pl-PL, vi-VN, th-TH, en-GB |  |
|**responseLanguage** | **String** | Language for the analysis results (labels, categories, levels). Can differ from &#39;language&#39; (input). If omitted, uses &#39;language&#39;. Accepted: en-US, es-ES, es-MX, pt-BR, fr-FR, de-DE, it-IT, pt-PT, zh-CN, ja-JP, ko-KR, ar-SA, hi-IN, ru-RU, id-ID, tr-TR, nl-NL, pl-PL, vi-VN, th-TH, en-GB. |  [optional] |
|**durationSeconds** | **BigDecimal** | Total audio duration in seconds. Required. Max 3h (10800s). |  |
|**clientReferenceId** | **String** | Optional client-supplied ID echoed verbatim in the response. Use to correlate/sync with your system. Accepted charset: [A-Za-z0-9._:-], max 128 chars. Not idempotency. |  [optional] |
|**callDirection** | [**CallDirectionEnum**](#CallDirectionEnum) | Who originated the call. inbound&#x3D;client called, outbound&#x3D;company called. If omitted, the LLM infers from context. |  [optional] |
|**participants** | [**List&lt;DiagnosticParticipant&gt;**](DiagnosticParticipant.md) | Explicit participant roles. If omitted, the LLM infers from the dialog. When provided, used as ground truth (no inference) and echoed in analysis.participants_identified. |  [optional] |



## Enum: CallDirectionEnum

| Name | Value |
|---- | -----|
| INBOUND | &quot;inbound&quot; |
| OUTBOUND | &quot;outbound&quot; |



