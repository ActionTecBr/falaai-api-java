

# WhatsappMeta


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_file** | **String** | Uploaded file name |  |
|**chatTxt** | **String** | chat.txt entry name inside the export |  |
|**format** | **String** | Detected format: Android | iOS |  |
|**dateFormat** | **String** | Date order used |  |
|**timezone** | **String** | Timezone informed |  |
|**start** | **String** | Window start (ISO) |  |
|**end** | **String** | Window end (ISO) |  |
|**gapMinutes** | **BigDecimal** | Gap used to split conversations |  |
|**minMessages** | **Integer** | Minimum messages per conversation |  |
|**charsPerMinute** | **BigDecimal** | Chars per minute used to estimate duration |  |
|**turns** | **Integer** | Total parsed turns |  |
|**systemLines** | **Integer** | System lines ignored |  |
|**conversationsTotal** | **Integer** | Conversations before window filter |  |
|**conversationsInWindow** | **Integer** | Conversations overlapping the window |  |
|**monologuesDropped** | **Integer** | Single-speaker conversations dropped |  |
|**conversationsSelected** | **Integer** | Final conversations returned |  |



