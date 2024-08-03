package edu.miu.navsenddatavm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import edu.miu.navsenddatavm.model.Student
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel

@Composable
fun ScreenOne(navController: NavController, modifier: Modifier, viewModel: SharedViewModel) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val student = Student("Tom", 21, "B")
        Text(text = "Screen One")
        Button(
            onClick = {
                viewModel.setStudent(student)
                navController.navigate("screenTwo")
            }
        ) {
            Text(text = "Go to Screen 2")
        }
    }
}