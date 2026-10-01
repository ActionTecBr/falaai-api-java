

# TranscriptionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique transcription identifier. Prefix &#39;tr-&#39; followed by UUID |  |
|**_object** | **String** | Returned object type. Always &#39;transcription&#39; |  |
|**model** | **String** | Model used for transcription. Ex: &#39;falaai-transcribe-1&#39; |  |
|**filename** | **String** | Original audio file name uploaded |  |
|**processedAt** | **String** | Processing datetime in ISO 8601 UTC format |  |
|**usage** | [**TranscriptionUsage**](TranscriptionUsage.md) | Usage and processing information |  |
|**language** | **String** | ISO 639-3 language code detected in audio. Ex: &#39;por&#39; (Portuguese), &#39;eng&#39; (English), &#39;spa&#39; (Spanish) |  |
|**languageConfidence** | **BigDecimal** | Language detection confidence level (0.0 to 1.0). Higher is more reliable |  [optional] |
|**durationSeconds** | **BigDecimal** | Total audio duration in seconds |  |
|**text** | **String** | Full transcription as plain text, including audio events in brackets |  |
|**dialog** | **String** | Turn-by-turn formatted transcript with speaker identification and start/end timestamps |  |
|**audioEvents** | [**List&lt;AudioEvent&gt;**](AudioEvent.md) | List of detected audio events (laughs, sighs, pauses, etc) with timestamps and duration |  |
|**eventTypes** | **List&lt;String&gt;** | Unique audio event types found in transcription, alphabetically sorted |  |
|**wordCount** | **Integer** | Total number of recognized words in transcription |  |
|**input** | [**AudioInputMeta**](AudioInputMeta.md) | Metadados do arquivo de audio enviado (duracao, formato, codec, sample rate, canais) |  |
|**clientReferenceId** | **String** | Client-supplied ID echoed verbatim (if provided in request) |  [optional] |



