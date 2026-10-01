

# DiagnosticResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique analysis identifier. Prefix &#39;di-&#39; + UUID |  |
|**responseLanguage** | **String** | Language used in the response. E.g.: &#39;pt-BR&#39;, &#39;en-US&#39;, &#39;es-ES&#39; |  |
|**_object** | **String** | Object type. Always &#39;analysis&#39; |  |
|**analysis** | [**DiagnosticAnalysisMap**](DiagnosticAnalysisMap.md) | The 6 conversation analyses (5 + participants) |  |
|**usage** | [**DiagnosticUsage**](DiagnosticUsage.md) | Usage and processing information |  |
|**clientReferenceId** | **String** | Client-supplied ID echoed verbatim (if provided in request) |  [optional] |



