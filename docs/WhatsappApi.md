# WhatsappApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**extractConversationsV1WhatsappExtractConversationsPost**](WhatsappApi.md#extractConversationsV1WhatsappExtractConversationsPost) | **POST** /v1/whatsapp/extractConversations | Extract and segment WhatsApp conversations from an export |


<a id="extractConversationsV1WhatsappExtractConversationsPost"></a>
# **extractConversationsV1WhatsappExtractConversationsPost**
> WhatsappConversationsResponse extractConversationsV1WhatsappExtractConversationsPost(_file, start, end, timezone, dateFormat, gapMinutes, minMessages, charsPerMinute, clientReferenceId)

Extract and segment WhatsApp conversations from an export

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.WhatsappApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    WhatsappApi apiInstance = new WhatsappApi(defaultClient);
    File _file = new File("/path/to/file"); // File | 
    String start = "start_example"; // String | 
    String end = "end_example"; // String | 
    String timezone = "timezone_example"; // String | 
    String dateFormat = "dateFormat_example"; // String | 
    BigDecimal gapMinutes = new BigDecimal("720"); // BigDecimal | 
    Integer minMessages = 2; // Integer | 
    BigDecimal charsPerMinute = new BigDecimal("800"); // BigDecimal | 
    String clientReferenceId = "clientReferenceId_example"; // String | 
    try {
      WhatsappConversationsResponse result = apiInstance.extractConversationsV1WhatsappExtractConversationsPost(_file, start, end, timezone, dateFormat, gapMinutes, minMessages, charsPerMinute, clientReferenceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WhatsappApi#extractConversationsV1WhatsappExtractConversationsPost");
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
| **_file** | **File**|  | |
| **start** | **String**|  | |
| **end** | **String**|  | |
| **timezone** | **String**|  | |
| **dateFormat** | **String**|  | |
| **gapMinutes** | **BigDecimal**|  | [optional] [default to 720] |
| **minMessages** | **Integer**|  | [optional] [default to 2] |
| **charsPerMinute** | **BigDecimal**|  | [optional] [default to 800] |
| **clientReferenceId** | **String**|  | [optional] |

### Return type

[**WhatsappConversationsResponse**](WhatsappConversationsResponse.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

