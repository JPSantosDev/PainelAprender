package br.senai.painelaprender.ui.viewmodel

import androidx.core.graphics.convertTo
import androidx.lifecycle.ViewModel
import br.senai.painelaprender.ui.state.CursoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import br.senai.painelaprender.ui.enum.CursoStatus
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
            onFiltroChange(novoTexto = "", novoStatus = CursoStatus.TODOS)

        }
    }
    fun onFiltroChange(novoTexto: String, novoStatus: CursoStatus?,){
        val cursosFiltrados = executarFiltros(novoTexto,novoStatus)

        val quantCursos = cursosFiltrados.size
        val quantEmAndamento = cursosFiltrados.count{it.status == CursoStatus.EM_ANDAMENTO}
        val quantConcluida = cursosFiltrados.count{it.status == CursoStatus.CONCLUIDO}
        val mediaProgresso = if (cursosOriginal.isNotEmpty()){
            cursosOriginal.map { it.progresso }.average()
        }
        else 0.0

        _uiState.update { it.copy(
            isLoading = false,
            isEmpty = cursosFiltrados.isEmpty(),
            cursos = cursosFiltrados,
            cursosEmAndamento = quantEmAndamento,
            totalCurso = quantCursos,
            cursosConcluidos = quantConcluida,
            mediaProgresso = mediaProgresso,
            statusSelecionado = novoStatus,
            textoBusca = novoTexto
        ) }
    }
    fun carregarCursoPorId(id: Int){
        val cursoEncontrado = cursosOriginal.find { it.id == id}
        _uiState.update {
            it.copy(cursoSelecionado = cursoEncontrado)
        }
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
    fun executarFiltros(novoTexto: String, novoStatus: CursoStatus?): List<Curso>{
        val cursoFiltradoBusca = cursosOriginal.filter {  if(novoTexto.toIntOrNull() != null) it.id == novoTexto.toInt() else it.nome.contains(novoTexto,ignoreCase = true) || it.categoria.contains(novoTexto, ignoreCase = true) }
        val cursoFiltradoStatus =
            if(novoStatus == CursoStatus.TODOS){
                cursoFiltradoBusca
            }
            else {cursoFiltradoBusca.filter { it.status == novoStatus }}

        return cursoFiltradoStatus
    }

    init {
        carregarCurso()
    }
}






