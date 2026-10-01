# WebhooksApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createWebhookV1WebhooksPost**](WebhooksApi.md#createWebhookV1WebhooksPost) | **POST** /v1/webhooks | Create webhook |
| [**deleteWebhookV1WebhooksWebhookIdDelete**](WebhooksApi.md#deleteWebhookV1WebhooksWebhookIdDelete) | **DELETE** /v1/webhooks/{webhook_id} | Delete webhook |
| [**listWebhooksV1WebhooksGet**](WebhooksApi.md#listWebhooksV1WebhooksGet) | **GET** /v1/webhooks | List webhooks |
| [**updateWebhookV1WebhooksWebhookIdPut**](WebhooksApi.md#updateWebhookV1WebhooksWebhookIdPut) | **PUT** /v1/webhooks/{webhook_id} | Update webhook |


<a id="createWebhookV1WebhooksPost"></a>
# **createWebhookV1WebhooksPost**
> WebhookItem createWebhookV1WebhooksPost(createWebhookRequest)

Create webhook

Creates a subscription for alert events (10 alerts). Payload delivered: WebhookPayload(event, data, timestamp) with HMAC FalaAI-Signature. To verify the origin, recompute HMAC-SHA256 of \&quot;timestamp.body\&quot; with your secret.

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.WebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    WebhooksApi apiInstance = new WebhooksApi(defaultClient);
    CreateWebhookRequest createWebhookRequest = new CreateWebhookRequest(); // CreateWebhookRequest | 
    try {
      WebhookItem result = apiInstance.createWebhookV1WebhooksPost(createWebhookRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#createWebhookV1WebhooksPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createWebhookRequest** | [**CreateWebhookRequest**](CreateWebhookRequest.md)|  | |

### Return type

[**WebhookItem**](WebhookItem.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

<a id="deleteWebhookV1WebhooksWebhookIdDelete"></a>
# **deleteWebhookV1WebhooksWebhookIdDelete**
> MessageResponse deleteWebhookV1WebhooksWebhookIdDelete(webhookId)

Delete webhook

Deletes a webhook subscription by ID.

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.WebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    WebhooksApi apiInstance = new WebhooksApi(defaultClient);
    String webhookId = "webhookId_example"; // String | 
    try {
      MessageResponse result = apiInstance.deleteWebhookV1WebhooksWebhookIdDelete(webhookId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#deleteWebhookV1WebhooksWebhookIdDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

<a id="listWebhooksV1WebhooksGet"></a>
# **listWebhooksV1WebhooksGet**
> WebhookListResponse listWebhooksV1WebhooksGet(page, limit)

List webhooks

Lists the authenticated user&#39;s webhooks (10 alerts). Paginated. Includes the URL signature secret (always visible to the owner).

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.WebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    WebhooksApi apiInstance = new WebhooksApi(defaultClient);
    Integer page = 1; // Integer | Pagina (1-indexed)
    Integer limit = 20; // Integer | Itens por pagina (max 100)
    try {
      WebhookListResponse result = apiInstance.listWebhooksV1WebhooksGet(page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#listWebhooksV1WebhooksGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| Pagina (1-indexed) | [optional] [default to 1] |
| **limit** | **Integer**| Itens por pagina (max 100) | [optional] [default to 20] |

### Return type

[**WebhookListResponse**](WebhookListResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

<a id="updateWebhookV1WebhooksWebhookIdPut"></a>
# **updateWebhookV1WebhooksWebhookIdPut**
> MessageResponse updateWebhookV1WebhooksWebhookIdPut(webhookId, updateWebhookRequest)

Update webhook

Updates the webhook&#39;s name/url/events/retry_enabled/active. Valid events: 10 alerts.

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.WebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    WebhooksApi apiInstance = new WebhooksApi(defaultClient);
    String webhookId = "webhookId_example"; // String | 
    UpdateWebhookRequest updateWebhookRequest = new UpdateWebhookRequest(); // UpdateWebhookRequest | 
    try {
      MessageResponse result = apiInstance.updateWebhookV1WebhooksWebhookIdPut(webhookId, updateWebhookRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhooksApi#updateWebhookV1WebhooksWebhookIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **webhookId** | **String**|  | |
| **updateWebhookRequest** | [**UpdateWebhookRequest**](UpdateWebhookRequest.md)|  | |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

