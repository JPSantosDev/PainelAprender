package br.senai.painelaprender.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.painelaprender.ui.state.CursoUiState
import br.senai.painelaprender.ui.theme.Typography


@Composable
fun PainelResumo(
    uiState: CursoUiState,

){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp,Alignment.CenterHorizontally))
    {
        Card(modifier = Modifier.weight(1f)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text("Total: ", style = Typography.bodySmall)
                Text("${uiState.totalCurso}", style = Typography.titleMedium)
            }
        }
        Card(modifier = Modifier.weight(1f)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text("Concluídos: ", style = Typography.bodySmall)
                Text("${uiState.cursosConcluidos}", style = Typography.titleMedium)
            }
        }
        Card(modifier = Modifier.weight(1f)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text("Em Andamento: ", style = Typography.bodySmall)
                Text("${uiState.cursosEmAndamento}", style = Typography.titleMedium)
            }
        }
        Card(modifier = Modifier.weight(1f)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text("Média de Progresso: ", style = Typography.bodySmall)
                Text("%.2f%%".format(uiState.mediaProgresso), style = Typography.titleMedium)
            }
        }
    }
}

@Composable
@Preview
fun PreviewPainelResumo(){
    val uiState = CursoUiState()
    PainelResumo(uiState)
}