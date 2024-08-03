package edu.miu.navsenddatavm.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import edu.miu.navsenddatavm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var canNavigateBack by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    navHostController.addOnDestinationChangedListener { _, destination, _ ->
        canNavigateBack = navHostController.currentBackStackEntry?.destination?.route != "screenOne"
    }
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_bar),
                style = MaterialTheme.typography.headlineMedium
                )
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            // Navigation Icon
            val navIcon = if (canNavigateBack) Icons.AutoMirrored.Default.ArrowBack else Icons.Default.Home
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(imageVector = navIcon, contentDescription = "Nav Icon")
            }
        }
    )
}