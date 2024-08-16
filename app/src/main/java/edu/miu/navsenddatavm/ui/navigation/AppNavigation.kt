package edu.miu.navsenddatavm.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.miu.navsenddatavm.ui.components.AppBar
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel
import edu.miu.navsenddatavm.ui.screens.ScreenOne
import edu.miu.navsenddatavm.ui.screens.ScreenTwo

@Composable
fun AppNavigation(viewModel: SharedViewModel) {
    var navHostController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AppBar(modifier = Modifier, navHostController) }
    ) { innerPadding ->
        NavHost(navController = navHostController, startDestination = "screenOne") {
            composable(route = "screenOne") {
                ScreenOne(navController = navHostController, modifier = Modifier.padding(innerPadding), viewModel = viewModel)
            }
            composable(route = "screenTwo") {
                ScreenTwo(navController = navHostController, modifier = Modifier.padding(innerPadding), viewModel = viewModel)
            }
        }
    }

}