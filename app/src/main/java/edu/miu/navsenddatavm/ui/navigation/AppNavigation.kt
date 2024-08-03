package edu.miu.navsenddatavm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel
import edu.miu.navsenddatavm.ui.screens.ScreenOne
import edu.miu.navsenddatavm.ui.screens.ScreenTwo

@Composable
fun AppNavigation(navHostController: NavHostController, modifier: Modifier = Modifier, viewModel: SharedViewModel) {
    NavHost(navController = navHostController, startDestination = "screenOne") {
        composable(route = "screenOne") {
            ScreenOne(navController = navHostController, modifier = modifier, viewModel = viewModel)
        }
        composable(route = "screenTwo") {
            ScreenTwo(navController = navHostController, modifier = modifier, viewModel = viewModel)
        }
    }
}