package br.senai.painelaprender.ui.state

import br.senai.painelaprender.ui.model.Curso

data class CursoUiState(
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val cursos: List<Curso> = emptyList(),
    val textoBusca: String = "",
    val cursoSelecionado:Curso? = null
)