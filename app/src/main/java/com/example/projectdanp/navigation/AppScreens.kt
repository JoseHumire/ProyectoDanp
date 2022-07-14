package com.example.projectdanp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object EntryListScreen : AppScreens("entryListScreen","Entries", Icons.Filled.Home)
    object EditEntryScreen : AppScreens("editEntryScreen", "Edit Entry", Icons.Filled.Email)
//    object EstadisticaScreen : AppScreens("estadistica_screen", "Estadísticas", Icons.Filled.Info)
//    object EditEstadisticaScreen : AppScreens("editEstadisticaScreen","Edit Estadisticas", Icons.Filled.Edit)
}