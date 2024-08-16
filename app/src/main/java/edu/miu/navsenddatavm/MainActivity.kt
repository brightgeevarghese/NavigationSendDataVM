package edu.miu.navsenddatavm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import edu.miu.navsenddatavm.ui.navigation.AppNavigation
import edu.miu.navsenddatavm.ui.viewmodel.SharedViewModel
import edu.miu.navsenddatavm.ui.theme.NavSendDataViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavSendDataViewModelTheme {
                val sharedViewModel: SharedViewModel by viewModels()
                AppNavigation(viewModel = sharedViewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    NavSendDataViewModelTheme {
        val sharedViewModel: SharedViewModel = SharedViewModel()
        AppNavigation(viewModel = sharedViewModel)
    }
}