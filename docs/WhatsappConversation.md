

# WhatsappConversation


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**conversationId** | **String** | Conversation identifier in the batch |  |
|**firstAt** | **String** | Real start (wall-clock, ISO) |  |
|**lastAt** | **String** | Real end (wall-clock, ISO) |  |
|**durationSeconds** | **BigDecimal** | (last - first) + last turn duration |  |
|**speakers** | [**List&lt;WhatsappSpeaker&gt;**](WhatsappSpeaker.md) | Speakers of THIS conversation (dynamic) |  |
|**dialog** | **String** | Lines &#39;Speaker N: [HH:MM:SS.mmm - HH:MM:SS.mmm] text&#39; (real offset) |  |
|**messageCount** | **Integer** | Number of messages |  |
|**characters** | **Integer** | Total characters of the conversation |  |



