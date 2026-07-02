package br.senai.painelaprender.ui.navigation

object Routes {

    const val LISTA_CURSOS = "lista_cursos"
    const val DETALHE_CURSO = "detalhe_curso/{cursoId}"

    fun criarUrlDetalhe(cursoId: Int): String {
        return "detalhe_curso/$cursoId"
    }
}