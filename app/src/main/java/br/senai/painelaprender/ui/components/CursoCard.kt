package br.senai.painelaprender.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.painelaprender.ui.model.Curso
import br.senai.painelaprender.ui.theme.Typography

@Composable
fun CursoCard(
    modifier:Modifier = Modifier,
    curso: Curso,
    onCardClick: () -> Unit

){
    Card(modifier
        .fillMaxWidth()
        .clickable(onClick = onCardClick)) {
        Column(modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = curso.nome,
                style = Typography.titleLarge
            )
            Text(text = curso.id.toString(),
                style = Typography.bodyMedium)

            Text(text = curso.cargaHoraria.toString(),
                style = Typography.bodyMedium)

            Text(text = curso.categoria,
                style = Typography.bodySmall)
        }
    }
}

@Preview
@Composable
fun CursoCardPreview(){
    CursoCard(
        curso = Curso("Android",1,20,"sim"),
        onCardClick = {}
    )
}