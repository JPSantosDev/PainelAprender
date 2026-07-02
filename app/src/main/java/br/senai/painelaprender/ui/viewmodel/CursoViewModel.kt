package br.senai.painelaprender.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.senai.painelaprender.ui.state.CursoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import br.senai.painelaprender.ui.model.Curso
import br.senai.painelaprender.ui.repository.CursoRepositoryFake
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CursoViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(CursoUiState())

    val uiState = _uiState.asStateFlow()

    val repositoryFake = CursoRepositoryFake()

    private var cursosOriginal = emptyList<Curso>()

    fun carregarCurso(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val cursos = repositoryFake.obterCurso()

            cursosOriginal = cursos

            atualizarEstado(cursos)

        }
    }
    fun onTextoBuscaChange(novoTexto: String){

        _uiState.update { it.copy(textoBusca = novoTexto) }

        val cursosFiltrados = if(novoTexto.isBlank()) {
            cursosOriginal
        }
        else{
            cursosOriginal.filter { curso -> curso.nome.contains(novoTexto, ignoreCase = true) || curso.categoria.contains(novoTexto, ignoreCase = true)}
        }
        atualizarEstado(cursosFiltrados)
    }
    fun atualizarEstado(list: List<Curso>){
        _uiState.update {
            it.copy(
                isLoading = false,
                isEmpty = list.isEmpty(),
                cursos = list
            )
        }
    }

    init {
        carregarCurso()
    }
}






