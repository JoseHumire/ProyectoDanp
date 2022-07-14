package com.example.projectdanp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projectdanp.data.Entry
import com.example.projectdanp.data.EntryViewModel
import com.example.projectdanp.presentation.EditEntryScreen
import com.example.projectdanp.presentation.EntriesScreen
import java.time.LocalDateTime

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModelEntry: EntryViewModel,
) {

    val allEntrys by viewModelEntry.fetchAllEntry().observeAsState(listOf())
    var entry: Entry
    NavHost(navController = navController, startDestination = AppScreens.EntryListScreen.route) {
        composable(
            route = AppScreens.EntryListScreen.route
        ) {
            EntriesScreen(navController, viewModelEntry)
        }
        composable(
            route = AppScreens.EditEntryScreen.route,
        ) {

            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Int>("entry")
            if (result != null) {
                entry = allEntrys.filter { it.id == result }[0]
                EditEntryScreen(navController, entry, viewModelEntry)
            } else {
                val current = LocalDateTime.now()
                EditEntryScreen(
                    navController,
                    Entry(
                        0,
                        day = current.dayOfMonth,
                        month = current.monthValue,
                        year = current.year,
                        amount = 0.0,
                        description = "",
                        currency = "Soles",
                        isIncome = true,
                    ),
                    viewModelEntry
                )
            }
        }
    }
}