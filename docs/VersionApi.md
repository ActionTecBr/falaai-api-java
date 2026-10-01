# VersionApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getVersionApiVersionGet**](VersionApi.md#getVersionApiVersionGet) | **GET** /api/version | Get Version |


<a id="getVersionApiVersionGet"></a>
# **getVersionApiVersionGet**
> VersionResponse getVersionApiVersionGet()

Get Version

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.models.*;
import com.falaai.api.VersionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");

    VersionApi apiInstance = new VersionApi(defaultClient);
    try {
      VersionResponse result = apiInstance.getVersionApiVersionGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VersionApi#getVersionApiVersionGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**VersionResponse**](VersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |

