package br.senai.painelaprender.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.senai.painelaprender.ui.model.Curso
import br.senai.painelaprender.ui.screens.CursoDetalheScreen
import br.senai.painelaprender.ui.screens.CursoScreen
import br.senai.painelaprender.ui.viewmodel.CursoViewModel

@Composable
fun NavHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val viewModel : CursoViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.LISTA_CURSOS,
    ){
        composable ( route = Routes.LISTA_CURSOS ){
            CursoScreen(onCardClick = {idCurso ->
                navController.navigate(Routes.criarUrlDetalhe(idCurso))})
        }

        composable (
            route = Routes.DETALHE_CURSO,
            arguments = listOf(navArgument("cursoId"){type = NavType.IntType}
            )
        ){backStackEntry ->
            val cursoId = backStackEntry.arguments?.getInt("cursoId") ?: 0

            CursoDetalheScreen(
                cursoId = cursoId,
                onVoltarClick = {navController.popBackStack()},
                viewModel = viewModel
            )
        }
    }
}