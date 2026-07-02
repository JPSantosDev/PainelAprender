package br.senai.painelaprender.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.senai.painelaprender.ui.screens.CursoDetalheScreen
import br.senai.painelaprender.ui.screens.CursoScreen

@Composable
fun NavHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.LISTA_CURSOS,
    ){
        composable ( route = Routes.LISTA_CURSOS ){
            CursoScreen(onCardClick = {idCurso ->
                navController.navigate(Routes.criarUrlDetalhe(idCurso))})
        }

        composable (route = Routes.DETALHE_CURSO){
            CursoDetalheScreen()
        }
    }
}