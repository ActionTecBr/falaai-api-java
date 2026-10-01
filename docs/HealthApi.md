# HealthApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**healthCheck**](HealthApi.md#healthCheck) | **GET** /v1/health | Health Check |
| [**healthCheckHead**](HealthApi.md#healthCheckHead) | **HEAD** /v1/health | Health Check |


<a id="healthCheck"></a>
# **healthCheck**
> HealthResponse healthCheck()

Health Check

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.models.*;
import com.falaai.api.HealthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");

    HealthApi apiInstance = new HealthApi(defaultClient);
    try {
      HealthResponse result = apiInstance.healthCheck();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HealthApi#healthCheck");
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

[**HealthResponse**](HealthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |

<a id="healthCheckHead"></a>
# **healthCheckHead**
> HealthResponse healthCheckHead()

Health Check

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.models.*;
import com.falaai.api.HealthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");

    HealthApi apiInstance = new HealthApi(defaultClient);
    try {
      HealthResponse result = apiInstance.healthCheckHead();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HealthApi#healthCheckHead");
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

[**HealthResponse**](HealthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |

