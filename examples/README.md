# sdks/java/examples - exemplos java (canonicos)

@version 1.4.0 | criado: 28/09/2026 17:22 | atualizado: 30/09/2026 21:27

## O que e
Os 4 exemplos java (java) dos endpoints da API, EXPORTADOS DA LANDING PAGE (fonte unica
de verdade). Nunca editados a mao.

## Fonte unica de verdade
- FalaAI_landing/lib/sandbox-examples.ts -> SANDBOX_EXAMPLES[<endpoint>].java
- que INTERPOLA FalaAI_landing/lib/sandbox-json-example.ts (SANDBOX_JSON_EXAMPLE = dados reais).

## Script (ferramenta)
_generate_java_examples.mjs (prefixo _ = ferramenta, nao exemplo)

| Comando                                      | Acao                                                      |
|----------------------------------------------|-----------------------------------------------------------|
| node _generate_java_examples.mjs             | Exporta (escreve os java a partir da landing + README)     |
| node _generate_java_examples.mjs --check     | Verifica (compara java x landing; exit 1 se divergir)      |

- Roda de QUALQUER pasta (resolve a landing pelo proprio caminho).
- Pre-requisito: Node (v22+).
- NUNCA edite os java nem este README a mao: edite a landing e reexecute o script.

## Ordem obrigatoria (regra)
1. Altere a FONTE (landing / SANDBOX_JSON_EXAMPLE).
2. Valide o cURL primeiro:  node _generate_java_examples.mjs --check   (exit 0 = ok)
3. So depois espelhe nas linguagens.
4. Cadeia integrada no pipeline: scripts/regenerate_all.py (T11) exporta via node.

## Relatorio da ultima execucao
| Data | Modo | Resultado |
|------|------|-----------|
| 30/09/2026 21:27 | verificacao (--check) | OK - 4 exemplos java 100% conforme a landing. |

| Arquivo | Endpoint | Status | Gerado em |
|---------|----------|--------|-----------|
| HealthExample.java | GET  /v1/health | ok | 30/09/2026 21:16 |
| TranscribeExample.java | POST /v1/audio/transcriptions | ok | 30/09/2026 21:16 |
| DiagnoseExample.java | POST /v1/analyze/diagnostic | ok | 30/09/2026 21:16 |
| AuditExample.java | POST /v1/analyze/riskAudit | ok | 30/09/2026 21:16 |

## Datas
- Criacao:     28/09/2026 17:22
- Atualizacao: 30/09/2026 21:27

Gerado automaticamente por _generate_java_examples.mjs - NAO edite a mao.
