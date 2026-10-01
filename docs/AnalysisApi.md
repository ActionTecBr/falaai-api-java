# AnalysisApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDiagnosticV1AnalyzeDiagnosticPost**](AnalysisApi.md#createDiagnosticV1AnalyzeDiagnosticPost) | **POST** /v1/analyze/diagnostic | Analyze a call transcript — 5 parallel analyses |
| [**createRiskAuditV1AnalyzeRiskAuditPost**](AnalysisApi.md#createRiskAuditV1AnalyzeRiskAuditPost) | **POST** /v1/analyze/riskAudit | Compliance Risk Audit — conversation compliance analysis |


<a id="createDiagnosticV1AnalyzeDiagnosticPost"></a>
# **createDiagnosticV1AnalyzeDiagnosticPost**
> DiagnosticResponse createDiagnosticV1AnalyzeDiagnosticPost(diagnosticRequest)

Analyze a call transcript — 5 parallel analyses

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.AnalysisApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    AnalysisApi apiInstance = new AnalysisApi(defaultClient);
    DiagnosticRequest diagnosticRequest = new DiagnosticRequest(); // DiagnosticRequest | 
    try {
      DiagnosticResponse result = apiInstance.createDiagnosticV1AnalyzeDiagnosticPost(diagnosticRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalysisApi#createDiagnosticV1AnalyzeDiagnosticPost");
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
| **diagnosticRequest** | [**DiagnosticRequest**](DiagnosticRequest.md)|  | |

### Return type

[**DiagnosticResponse**](DiagnosticResponse.md)

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

<a id="createRiskAuditV1AnalyzeRiskAuditPost"></a>
# **createRiskAuditV1AnalyzeRiskAuditPost**
> RiskAuditV2Response createRiskAuditV1AnalyzeRiskAuditPost(riskAuditRequest)

Compliance Risk Audit — conversation compliance analysis

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.AnalysisApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    AnalysisApi apiInstance = new AnalysisApi(defaultClient);
    RiskAuditRequest riskAuditRequest = new RiskAuditRequest(); // RiskAuditRequest | 
    try {
      RiskAuditV2Response result = apiInstance.createRiskAuditV1AnalyzeRiskAuditPost(riskAuditRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalysisApi#createRiskAuditV1AnalyzeRiskAuditPost");
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
| **riskAuditRequest** | [**RiskAuditRequest**](RiskAuditRequest.md)|  | |

### Return type

[**RiskAuditV2Response**](RiskAuditV2Response.md)

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

