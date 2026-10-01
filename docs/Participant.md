

# Participant


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**interlocutor** | **String** | Exact identifier as used in dialog (e.g. &#39;Interlocutor 1&#39;, &#39;Antonio&#39;) |  |
|**name** | **String** | Participant name (humanizes report, does not affect logic) |  [optional] |
|**role** | [**RoleEnum**](#RoleEnum) | Role: agent (human operator), client (customer), bot (IVR/AI) |  |



## Enum: RoleEnum

| Name | Value |
|---- | -----|
| AGENT | &quot;agent&quot; |
| CLIENT | &quot;client&quot; |
| BOT | &quot;bot&quot; |



