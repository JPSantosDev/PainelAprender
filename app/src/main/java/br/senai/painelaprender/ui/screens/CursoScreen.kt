package br.senai.painelaprender.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.painelaprender.ui.components.CursoCard
import br.senai.painelaprender.ui.viewmodel.CursoViewModel




@Composable
fun CursoScreen(
    modifier: Modifier = Modifier,
    viewModel: CursoViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    Column(modifier = modifier.fillMaxSize()) {
        if (!uiState.isLoading || !uiState.isEmpty) {
            OutlinedTextField(
                value = uiState.textoBusca,
                onValueChange = { novoTexto -> viewModel.onTextoBuscaChange(novoTexto) },
                label = { Text("Pesquisar Cursos") },
                modifier = modifier.padding(10.dp)
            )
        }


        when {
            uiState.isLoading -> {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.isEmpty -> {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Não há cursos cadastrados")
                }
            }

            else -> {

                Column(
                    modifier = modifier.fillMaxWidth()
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(uiState.cursos) { curso ->
                            CursoCard(curso = curso)
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview

fun CursoPreview(){
    CursoScreen()
}