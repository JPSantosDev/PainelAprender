package br.senai.painelaprender.ui.model

import br.senai.painelaprender.ui.enum.CursoStatus

data class Curso(

    val id: Int,
    val nome: String,
    val categoria: String,
    val status: CursoStatus,
    val progresso:Int,

)
