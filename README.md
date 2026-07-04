# Painel Aprender+ — App de Gestão de Cursos

Este repositório contém a implementação do **Painel Aprender+**, um aplicativo Android moderno focado na gestão e monitorização do progresso de cursos de formação. O projeto foi desenvolvido em **Kotlin** utilizando **Jetpack Compose** como ferramenta de UI declarativa, seguindo as diretrizes da Semana 08 do Módulo de Treinamento (Fase P1 - Base Algorítmica e Kotlin Competitivo).

O principal objetivo deste projeto é demonstrar o domínio de arquitetura reativa utilizando **ViewModel**, gerenciamento de estados com **StateFlow** (UDF — Unidirectional Data Flow) e componentização avançada de layouts.

---

## 🛠️ Arquitetura e Organização do Projeto

A solução foi estruturada seguindo os padrões de arquitetura limpa e separação de conceitos (Separation of Concerns), garantindo que a aplicação seja previsível, estável e escalável para futuras integrações (como bases de dados locais com Room ou APIs REST).

O projeto está dividido nas seguintes camadas estruturais dentro do pacote `ui`:

```text
br.senai.painelaprender.ui/
│
├── components/          # Componentes visuais reutilizáveis e isolados
│   ├── CursoCard.kt     # Cartão individual do curso com barra de progresso
│   └── PainelResumo.kt  # Dashboard superior com métricas em grelha (.weight)
│
├── enum/                # Tipagem estrita de regras de negócio
│   └── CursoStatus.kt   # Definição dos estados dos cursos (TODOS, ANDAMENTO, CONCLUIDO)
│
├── model/               # Modelos de dados (Entidades)
│   └── Curso.kt         # Classe de dados que representa um Curso
│
├── navigation/          # Infraestrutura de navegação entre ecrãs
│   └── NavHostGraph.kt  # Grafo de rotas e passagem de argumentos estruturados
│
├── screens/             # Ecrãs principais da aplicação (Composables de alto nível)
│   └── CursoScreen.kt   # Gestor de estados do ecrã principal (Loading, Error, Empty, Success)
│
├── state/               # Representação imutável do estado da interface
│   └── CursoUiState.kt  # Data class unificada com todas as variáveis do ecrã
│
└── viewmodel/           # Camada de regras de apresentação e mutação de estados
    └── CursoViewModel.kt# Emissor de estados reativos e centralizador de lógica
