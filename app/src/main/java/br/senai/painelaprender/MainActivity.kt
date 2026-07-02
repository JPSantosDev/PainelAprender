package br.senai.painelaprender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.senai.painelaprender.ui.screens.CursoScreen
import br.senai.painelaprender.ui.theme.PainelAprenderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PainelAprenderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CursoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}