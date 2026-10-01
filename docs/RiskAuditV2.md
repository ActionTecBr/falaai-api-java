

# RiskAuditV2

Response V2 (build_public_response_v2) — blocos logicos EN-US. Fonte: response_builder.py.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**meta** | [**RiskAuditMetaV2**](RiskAuditMetaV2.md) | Identification + usage |  |
|**participants** | [**RiskAuditParticipantsV2**](RiskAuditParticipantsV2.md) | Participants/roles/direction |  |
|**verdict** | [**RiskAuditVerdictV2**](RiskAuditVerdictV2.md) | Verdict + level + applied actions |  |
|**scores** | [**RiskAuditScoresV2**](RiskAuditScoresV2.md) | Consolidated + per-participant scores |  |
|**detections** | [**RiskAuditDetectionsV2**](RiskAuditDetectionsV2.md) | violations/positives/client alerts |  |
|**analysis** | [**RiskAuditAnalysisV2**](RiskAuditAnalysisV2.md) | global_metrics + final_analysis + frameworks |  |
|**timeline** | [**RiskAuditTimelineV2**](RiskAuditTimelineV2.md) | turns_sentiment + audio_events + groups |  |
|**audioEventModel** | [**RiskAuditAudioEventModelV2**](RiskAuditAudioEventModelV2.md) | MAC audio event semantics |  |
|**categoriesSummary** | **Map&lt;String, Object&gt;** | Per-category summary (keyed by category) |  |
|**indexer** | [**RiskAuditIndexerV2**](RiskAuditIndexerV2.md) | Suggested terms for bank |  |
|**summary** | [**RiskAuditSummaryV2**](RiskAuditSummaryV2.md) | Executive summary counts |  |
|**actionsI18n** | **Map&lt;String, Object&gt;** | Used actions i18n catalog (keyed by action) |  |
|**auditDecisions** | [**RiskAuditAuditDecisionsV2**](RiskAuditAuditDecisionsV2.md) | Risk origin + validator changes |  |
|**scoringExplanation** | [**RiskAuditScoringExplanationV2**](RiskAuditScoringExplanationV2.md) | Score composition explanation |  |
|**htmlReport** | **String** | HTML report (base64 gzip) |  |



