package edu.miu.navsenddatavm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.miu.navsenddatavm.ui.navigation.AppNavigation
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel
import edu.miu.navsenddatavm.ui.theme.NavSendDataViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavSendDataViewModelTheme {
                var navHostController: NavHostController = rememberNavController()
                // Initializes the sharedViewModel using the 'viewModels()' delegate for lifecycle-
                // aware data management within the UI components
                val sharedViewModel: SharedViewModel by viewModels()
                AppNavigation(navHostController = navHostController, viewModel = sharedViewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    NavSendDataViewModelTheme {
        var navHostController: NavHostController = rememberNavController()
        val sharedViewModel: SharedViewModel = SharedViewModel()
        AppNavigation(navHostController = navHostController, viewModel = sharedViewModel)
    }
}