package br.senai.painelaprender.ui.repository

import br.senai.painelaprender.ui.enum.CursoStatus
import br.senai.painelaprender.ui.model.Curso
import kotlinx.coroutines.delay

class CursoRepositoryFake {

     suspend fun obterCurso(): List<Curso> {
         delay(1000)
         return listOf(
             Curso(
                 id = 1,
                 nome = "Fundamentos de Android",
                 categoria = "Mobile",
                 status = CursoStatus.CONCLUIDO,
                 progresso = 100
             ),
             Curso(
                 id = 2,
                 nome = "Introdução ao Kotlin",
                 categoria = "Programação",
                 status = CursoStatus.CONCLUIDO,
                 progresso = 100
             ),
             Curso(
                 id = 3,
                 nome = "Jetpack Compose",
                 categoria = "Mobile",
                 status = CursoStatus.EM_ANDAMENTO,
                 progresso = 65
             ),
             Curso(
                 id = 4,
                 nome = "Arquitetura MVVM",
                 categoria = "Arquitetura",
                 status = CursoStatus.EM_ANDAMENTO,
                 progresso = 40
             ),
             Curso(
                 id = 5,
                 nome = "Git e Versionamento",
                 categoria = "Ferramentas",
                 status = CursoStatus.EM_ANDAMENTO,
                 progresso = 20
             ),
             Curso(
                 id = 6,
                 nome = "APIs REST com Retrofit",
                 categoria = "Backend",
                 status = CursoStatus.NAO_INICIADO,
                 progresso = 0
             ),
             Curso(
                 id = 7,
                 nome = "Banco de Dados com Room",
                 categoria = "Persistência",
                 status = CursoStatus.NAO_INICIADO,
                 progresso = 0
             ),
             Curso(
                 id = 8,
                 nome = "Testes no Android",
                 categoria = "Qualidade",
                 status = CursoStatus.NAO_INICIADO,
                 progresso = 0
             )
         )
     }
}
