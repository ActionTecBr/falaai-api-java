

# WhatsappConversationsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier. Prefix &#39;wc-&#39; + UUID |  |
|**_object** | **String** | Object type. Always &#39;conversations&#39; |  |
|**usage** | [**WhatsappUsage**](WhatsappUsage.md) | Usage and processing information |  |
|**conversations** | [**List&lt;WhatsappConversation&gt;**](WhatsappConversation.md) | Segmented conversations |  |
|**clientReferenceId** | **String** | Client-supplied ID echoed verbatim (if provided) |  [optional] |
|**meta** | [**WhatsappMeta**](WhatsappMeta.md) | Segmentation parameters and counts |  |



