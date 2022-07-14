package com.example.projectdanp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.projectdanp.data.EntryViewModel
import com.example.projectdanp.navigation.AppNavigation
import com.example.projectdanp.navigation.AppScreens
import com.example.projectdanp.presentation.components.ButtomNavigationBar
import com.example.projectdanp.ui.theme.ProjectDanpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val entryViewModel = ViewModelProvider(this).get(EntryViewModel::class.java)

        setContent {
            ProjectDanpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController() // Redirección de vistas

                    //BOTTOM NAVIGATION
                    val navigationItems = listOf(
                        AppScreens.EntryListScreen,
                    )
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Blue),
                        bottomBar = { ButtomNavigationBar(navController = navController, items = navigationItems) }
                    ) { innerPadding ->
                        // Apply the padding globally to the whole BottomNavScreensController
                        Surface(modifier = Modifier.padding(innerPadding)) {
                            AppNavigation(navController,entryViewModel)
                        }
                    }

                }
            }
        }
    }
}
