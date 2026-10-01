# SpeechApi

All URIs are relative to *https://api01-falaai.action.tec.br*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTranscriptionV1AudioTranscriptionsPost**](SpeechApi.md#createTranscriptionV1AudioTranscriptionsPost) | **POST** /v1/audio/transcriptions | Transcribe audio to text |


<a id="createTranscriptionV1AudioTranscriptionsPost"></a>
# **createTranscriptionV1AudioTranscriptionsPost**
> TranscriptionResponse createTranscriptionV1AudioTranscriptionsPost(_file, model, language, clientReferenceId)

Transcribe audio to text

### Example
```java
// Import classes:
import com.falaai.ApiClient;
import com.falaai.ApiException;
import com.falaai.Configuration;
import com.falaai.auth.*;
import com.falaai.models.*;
import com.falaai.api.SpeechApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api01-falaai.action.tec.br");
    
    // Configure HTTP bearer authorization: ApiKeyAuth
    HttpBearerAuth ApiKeyAuth = (HttpBearerAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setBearerToken("BEARER TOKEN");

    SpeechApi apiInstance = new SpeechApi(defaultClient);
    File _file = new File("/path/to/file"); // File | 
    String model = "falaai-transcribe-1"; // String | 
    String language = "pt"; // String | 
    String clientReferenceId = "clientReferenceId_example"; // String | Optional client-supplied ID echoed verbatim in the response. Use to correlate/sync with your system. Accepted charset: [A-Za-z0-9._:-]. Not idempotency.
    try {
      TranscriptionResponse result = apiInstance.createTranscriptionV1AudioTranscriptionsPost(_file, model, language, clientReferenceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpeechApi#createTranscriptionV1AudioTranscriptionsPost");
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
| **model** | **String**|  | [optional] [default to falaai-transcribe-1] |
| **language** | **String**|  | [optional] [default to pt] |
| **clientReferenceId** | **String**| Optional client-supplied ID echoed verbatim in the response. Use to correlate/sync with your system. Accepted charset: [A-Za-z0-9._:-]. Not idempotency. | [optional] |

### Return type

[**TranscriptionResponse**](TranscriptionResponse.md)

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

