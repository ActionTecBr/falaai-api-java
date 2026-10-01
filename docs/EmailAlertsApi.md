# EmailAlertsApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEmailAlertV1EmailAlertsPost**](EmailAlertsApi.md#createEmailAlertV1EmailAlertsPost) | **POST** /v1/email-alerts | Create email alert |
| [**deleteEmailAlertV1EmailAlertsAlertIdDelete**](EmailAlertsApi.md#deleteEmailAlertV1EmailAlertsAlertIdDelete) | **DELETE** /v1/email-alerts/{alert_id} | Delete email alert |
| [**listEmailAlertsV1EmailAlertsGet**](EmailAlertsApi.md#listEmailAlertsV1EmailAlertsGet) | **GET** /v1/email-alerts | List email alerts |
| [**updateEmailAlertV1EmailAlertsAlertIdPut**](EmailAlertsApi.md#updateEmailAlertV1EmailAlertsAlertIdPut) | **PUT** /v1/email-alerts/{alert_id} | Update email alert |


<a id="createEmailAlertV1EmailAlertsPost"></a>
# **createEmailAlertV1EmailAlertsPost**
> EmailAlertItem createEmailAlertV1EmailAlertsPost(createEmailAlertRequest)

Create email alert

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.EmailAlertsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    EmailAlertsApi apiInstance = new EmailAlertsApi(defaultClient);
    CreateEmailAlertRequest createEmailAlertRequest = new CreateEmailAlertRequest(); // CreateEmailAlertRequest | 
    try {
      EmailAlertItem result = apiInstance.createEmailAlertV1EmailAlertsPost(createEmailAlertRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmailAlertsApi#createEmailAlertV1EmailAlertsPost");
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
| **createEmailAlertRequest** | [**CreateEmailAlertRequest**](CreateEmailAlertRequest.md)|  | |

### Return type

[**EmailAlertItem**](EmailAlertItem.md)

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

<a id="deleteEmailAlertV1EmailAlertsAlertIdDelete"></a>
# **deleteEmailAlertV1EmailAlertsAlertIdDelete**
> EmailAlertMessageResponse deleteEmailAlertV1EmailAlertsAlertIdDelete(alertId)

Delete email alert

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.EmailAlertsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    EmailAlertsApi apiInstance = new EmailAlertsApi(defaultClient);
    String alertId = "alertId_example"; // String | 
    try {
      EmailAlertMessageResponse result = apiInstance.deleteEmailAlertV1EmailAlertsAlertIdDelete(alertId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmailAlertsApi#deleteEmailAlertV1EmailAlertsAlertIdDelete");
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
| **alertId** | **String**|  | |

### Return type

[**EmailAlertMessageResponse**](EmailAlertMessageResponse.md)

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

<a id="listEmailAlertsV1EmailAlertsGet"></a>
# **listEmailAlertsV1EmailAlertsGet**
> EmailAlertListResponse listEmailAlertsV1EmailAlertsGet(page, limit)

List email alerts

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.EmailAlertsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    EmailAlertsApi apiInstance = new EmailAlertsApi(defaultClient);
    Integer page = 1; // Integer | 
    Integer limit = 20; // Integer | 
    try {
      EmailAlertListResponse result = apiInstance.listEmailAlertsV1EmailAlertsGet(page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmailAlertsApi#listEmailAlertsV1EmailAlertsGet");
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

### Return type

[**EmailAlertListResponse**](EmailAlertListResponse.md)

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

<a id="updateEmailAlertV1EmailAlertsAlertIdPut"></a>
# **updateEmailAlertV1EmailAlertsAlertIdPut**
> EmailAlertMessageResponse updateEmailAlertV1EmailAlertsAlertIdPut(alertId, updateEmailAlertRequest)

Update email alert

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.EmailAlertsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    EmailAlertsApi apiInstance = new EmailAlertsApi(defaultClient);
    String alertId = "alertId_example"; // String | 
    UpdateEmailAlertRequest updateEmailAlertRequest = new UpdateEmailAlertRequest(); // UpdateEmailAlertRequest | 
    try {
      EmailAlertMessageResponse result = apiInstance.updateEmailAlertV1EmailAlertsAlertIdPut(alertId, updateEmailAlertRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmailAlertsApi#updateEmailAlertV1EmailAlertsAlertIdPut");
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
| **alertId** | **String**|  | |
| **updateEmailAlertRequest** | [**UpdateEmailAlertRequest**](UpdateEmailAlertRequest.md)|  | |

### Return type

[**EmailAlertMessageResponse**](EmailAlertMessageResponse.md)

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

