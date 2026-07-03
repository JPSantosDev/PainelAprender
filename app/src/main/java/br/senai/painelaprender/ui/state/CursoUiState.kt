package br.senai.painelaprender.ui.state

import br.senai.painelaprender.ui.enum.CursoStatus
import br.senai.painelaprender.ui.model.Curso

data class CursoUiState(
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val isError: Boolean = false,
    val cursos: List<Curso> = emptyList(),
    val textoBusca: String = "",
    val cursoSelecionado:Curso? = null,
    val statusSelecionado: CursoStatus? = null,
    val totalCurso:Int = 0,
    val cursosEmAndamento:Int = 0,
    val cursosConcluidos: Int = 0,
    val mediaProgresso:Double = 0.0,

)