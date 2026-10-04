# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [1.21.51] - 2026-10-04

### Added

- New endpoint `POST /v1/whatsapp/extractConversations` — extract and segment WhatsApp conversations from an export (`.zip`/`.txt`). New `WhatsappApi` + models (`WhatsappConversationsResponse`, `WhatsappConversation`, `WhatsappSpeaker`, `WhatsappUsage`, `WhatsappMeta`).
- Generated from the FalaAI API OpenAPI contract, version 1.21.51.

### Changed

- `RiskAuditRequest.responseFormat` is now the typed enum `RiskAuditRequest.ResponseFormatEnum` (only `V2` available today).


## [1.21.48] - 2026-09-28

### Changed

- Contract sync: bundled example payloads refreshed under FalaAI API api_v1.21.48 (health check payloads in the README now reflect the live version).

## [1.21.47] - 2026-09-22

### Added

- Initial public release of the FalaAI API Java SDK.
- Typed client for the three FalaAI API endpoints:
  - `POST /v1/audio/transcriptions` - audio to text, with speaker separation
  - `POST /v1/analyze/diagnostic` - conversation analysis
  - `POST /v1/analyze/auditoriaRisco` - compliance audit
- Generated from the FalaAI API OpenAPI contract, version 1.21.47.
- End-to-end test suite (19 tests).

[1.21.47]: https://github.com/ActionTecBr/falaai-api-java/releases/tag/v1.21.47
