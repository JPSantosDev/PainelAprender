package br.senai.painelaprender.ui.repository

import br.senai.painelaprender.ui.model.Curso
import kotlinx.coroutines.delay

class CursoRepositoryFake {

     suspend fun obterCurso(): List<Curso> {
         delay(1000)
         return listOf(
             Curso("Android", 1, 20, "sim"),
             Curso("Kotlin", 2, 40, "não"),
             Curso("Java", 3, 60, "talvez"),
             Curso("Python", 4, 80, "clarinho que sim"),
             Curso("JavaScript", 5, 100, "com certeza")
         )
     }
}
