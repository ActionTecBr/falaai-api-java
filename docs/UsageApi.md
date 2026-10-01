# UsageApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getUsageByKeyV1UsageByKeyGet**](UsageApi.md#getUsageByKeyV1UsageByKeyGet) | **GET** /v1/usage/by-key | Get Usage By Key |
| [**getUsageLogV1UsageLogGet**](UsageApi.md#getUsageLogV1UsageLogGet) | **GET** /v1/usage/log | Get Usage Log |


<a id="getUsageByKeyV1UsageByKeyGet"></a>
# **getUsageByKeyV1UsageByKeyGet**
> List&lt;UsageByKeyItem&gt; getUsageByKeyV1UsageByKeyGet(keyId)

Get Usage By Key

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.UsageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    UsageApi apiInstance = new UsageApi(defaultClient);
    String keyId = "keyId_example"; // String | 
    try {
      List<UsageByKeyItem> result = apiInstance.getUsageByKeyV1UsageByKeyGet(keyId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsageApi#getUsageByKeyV1UsageByKeyGet");
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
| **keyId** | **String**|  | [optional] |

### Return type

[**List&lt;UsageByKeyItem&gt;**](UsageByKeyItem.md)

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

<a id="getUsageLogV1UsageLogGet"></a>
# **getUsageLogV1UsageLogGet**
> UsageLogResponse getUsageLogV1UsageLogGet(page, limit, apiKeyId)

Get Usage Log

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.UsageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    UsageApi apiInstance = new UsageApi(defaultClient);
    Integer page = 1; // Integer | 
    Integer limit = 20; // Integer | 
    String apiKeyId = "apiKeyId_example"; // String | 
    try {
      UsageLogResponse result = apiInstance.getUsageLogV1UsageLogGet(page, limit, apiKeyId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsageApi#getUsageLogV1UsageLogGet");
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
| **page** | **Integer**|  | [optional] [default to 1] |
| **limit** | **Integer**|  | [optional] [default to 20] |
| **apiKeyId** | **String**|  | [optional] |

### Return type

[**UsageLogResponse**](UsageLogResponse.md)

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

