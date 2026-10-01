

# WebhookItem


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Webhook id |  |
|**userId** | **String** | Owner user id |  |
|**name** | **String** | Webhook name |  |
|**url** | **String** | Destination URL |  |
|**secret** | **String** | HMAC signing secret |  |
|**events** | **List&lt;String&gt;** | Subscribed events |  |
|**active** | **Boolean** | Is active |  |
|**retryEnabled** | **Boolean** | Retry enabled |  |
|**lastDeliveryAt** | **String** | ISO 8601 of last delivery |  [optional] |
|**lastStatus** | **Integer** | Last HTTP status delivered |  [optional] |
|**failureCount** | **Integer** | Consecutive failures |  [optional] |
|**createdAt** | **String** | ISO 8601 created |  |
|**updatedAt** | **String** | ISO 8601 updated |  |



