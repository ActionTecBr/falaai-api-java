

# WhatsappUsage


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**conversations** | **Integer** | Number of conversations returned |  |
|**characters** | **Integer** | Total characters across conversations |  |
|**expressions** | **Integer** | Expression tokens across conversations (sticker/emoji/gif) |  |
|**voiceNotes** | **Integer** | Voice notes (PTT) resolved to text |  |
|**conversationCredits** | **Integer** | Credits for conversations (2 each) |  |
|**expressionCredits** | **BigDecimal** | Credits for expressions (0.2 each) |  |
|**audioCredits** | **BigDecimal** | Credits for audio duration (0.2 per second) |  |
|**creditsConsumed** | **Integer** | Total credits &#x3D; ceil(conversation_credits + expression_credits + audio_credits) |  |
|**processingMs** | **Integer** | Total processing time in milliseconds |  |



