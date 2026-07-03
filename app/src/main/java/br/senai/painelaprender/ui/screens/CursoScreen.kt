package br.senai.painelaprender.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.painelaprender.ui.components.CursoCard
import br.senai.painelaprender.ui.components.PainelResumo
import br.senai.painelaprender.ui.enum.CursoStatus
import br.senai.painelaprender.ui.theme.Typography
import br.senai.painelaprender.ui.viewmodel.CursoViewModel




@Composable
fun CursoScreen(
    modifier: Modifier = Modifier,
    viewModel: CursoViewModel = viewModel(),
    onCardClick: (Int) -> Unit

) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()



    Column(
        modifier = modifier.fillMaxSize().padding(top = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Painel Aprender+", style = Typography.titleLarge)
        PainelResumo(uiState)
        if (!uiState.isLoading || !uiState.isEmpty) {
            OutlinedTextField(
                value = uiState.textoBusca,
                onValueChange = { novoTexto -> viewModel.onFiltroChange(novoTexto,uiState.statusSelecionado) },
                label = { Text("Pesquisar Cursos") },
                modifier = modifier.padding(10.dp)
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically) {

            CursoStatus.entries.forEach { status ->
                FilterChip(
                    selected = uiState.statusSelecionado == status,
                    onClick = {viewModel.onFiltroChange(uiState.textoBusca,status)},
                    label = {Text(text = status.label)},
                    leadingIcon = { Icon(imageVector = Icons.Default.Check, contentDescription = "") }
                )
            }
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
                            CursoCard(curso = curso, onCardClick = {onCardClick(curso.id)}
                            )
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
    CursoScreen(onCardClick = {})
}