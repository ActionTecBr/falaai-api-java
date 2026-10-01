

# CreateWebhookRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Nome identificador do webhook |  |
|**url** | **String** | URL HTTPS que recebera POST com HMAC FalaAI-Signature |  |
|**events** | **List&lt;WebhookEvent&gt;** | Eventos subscritos (10 alertas) |  |
|**retryEnabled** | **Boolean** | Retry exponencial 5 tentativas quando true (false&#x3D;1 tentativa) |  [optional] |



