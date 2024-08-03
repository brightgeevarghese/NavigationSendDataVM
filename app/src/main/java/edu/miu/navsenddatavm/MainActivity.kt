package edu.miu.navsenddatavm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.miu.navsenddatavm.ui.components.AppBar
import edu.miu.navsenddatavm.ui.navigation.AppNavigation
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel
import edu.miu.navsenddatavm.ui.theme.NavSendDataParcelableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavSendDataParcelableTheme {
                var navHostController: NavHostController = rememberNavController()
                val sharedViewModel: SharedViewModel by viewModels()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppBar(modifier = Modifier, navHostController) }
                ) { innerPadding ->
                    AppNavigation(
                        navHostController = navHostController,
                        modifier = Modifier.padding(innerPadding),
                        viewModel = sharedViewModel
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    NavSendDataParcelableTheme {
        var navHostController: NavHostController = rememberNavController()
        val sharedViewModel = SharedViewModel()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AppBar(modifier = Modifier, navHostController) }
        ) { innerPadding ->
            AppNavigation(navHostController = navHostController, modifier = Modifier.padding(innerPadding), viewModel = sharedViewModel)
        }
    }
}