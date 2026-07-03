package br.senai.painelaprender.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.painelaprender.ui.theme.Typography
import br.senai.painelaprender.ui.viewmodel.CursoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoDetalheScreen(
    cursoId: Int,
    onVoltarClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CursoViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(cursoId) {
        viewModel.carregarCursoPorId(cursoId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do Curso") },
                navigationIcon = {
                    IconButton(onClick = onVoltarClick){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            uiState.cursoSelecionado?.let { curso ->
                Text(
                    text = curso.nome,
                    style = Typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "ID: ${curso.id}",
                    style = Typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Categoria: ${curso.categoria}",
                    style = Typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

            } ?: run {
                Text("Buscando detalhes do curso...")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CursoDetalheScreenPreview(){
    CursoDetalheScreen(
        cursoId = 1,
        onVoltarClick = {}
    )
}