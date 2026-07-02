package br.senai.painelaprender.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.painelaprender.ui.viewmodel.CursoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoDetalheScreen(
    modifier: Modifier = Modifier,
    viewModel: CursoViewModel = viewModel(),
    cursoId: Int,
    onVoltarClick: () -> Unit

){


    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Detalhes do Curso") },
            navigationIcon = { IconButton(onClick = onVoltarClick){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar"
                )
            } }

        ) }
    ) {innerPadding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)) {


        }

    }

}

@Composable
@Preview

fun CursoDetalheScreenPreview(){
    CursoDetalheScreen(
        cursoId = 1,
        viewModel = viewModel(),
        onVoltarClick = {}
    )
}