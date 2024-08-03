package edu.miu.navsenddatavm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel


@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier, viewModel: SharedViewModel) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val studentUiState by viewModel.studentUIState.collectAsState()
        when {
            studentUiState.isLoading -> {
                Text(text = "Loading...")
            }
            studentUiState.error != null -> {
                Text(text = "Error: ${studentUiState.error}")
            }
            else -> {
                Text(text = "Student : $studentUiState")
            }
        }
        Button(onClick = { navController.popBackStack(navController.graph.startDestinationId, false) }) {
            Text(text = "Go back to Screen 1")
        }
    }
}