package com.example.projectdanp.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.paging.compose.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.projectdanp.data.Entry
import com.example.projectdanp.data.EntryViewModel
import com.example.projectdanp.navigation.AppScreens
import com.example.projectdanp.presentation.components.EntryRow
import com.example.projectdanp.presentation.components.InputValue
import com.example.projectdanp.presentation.components.TitleComponent
import com.example.projectdanp.presentation.components.TitleRow

@Composable
fun EntriesScreen(navController: NavController, viewModel: EntryViewModel) {

    val allEntrys = viewModel.allEntry.collectAsLazyPagingItems()
    val searchResults by viewModel.searchResults.observeAsState(listOf())


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(AppScreens.EditEntryScreen.route)
                    navController.previousBackStackEntry?.savedStateHandle?.remove<Entry>("entry")},
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    )
    {
        FirstMainScreen(
            allEntrys = allEntrys,
            searchResults = searchResults,
            viewModel = viewModel,
            navController = navController
        )
    }
}

@Composable
fun FirstMainScreen(
    allEntrys: LazyPagingItems<Entry>,
    searchResults: List<Entry>,
    viewModel: EntryViewModel,
    navController: NavController
) {
    Spacer(modifier = Modifier.height(10.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        var textSearch by remember { mutableStateOf("") }
        var searching by remember { mutableStateOf(false) }

        val onTextChange = { text: String ->
            textSearch = text
        }
        TitleComponent(title = "Expenses list")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            InputValue(
                title = "Search",
                textState = textSearch,
                onTextChange = onTextChange,
                keyboardType = KeyboardType.Text
            )
            Spacer(Modifier.width(20.dp))
            Button(
                onClick = {
                    searching = true
                    viewModel.findEntry("%$textSearch%")
                }) {
                Text("Search")
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Button(onClick = {
                searching = false
                viewModel.deleteAllEntry()
            }) {
                Text("Delete entries")
            }
        }

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val listEntries = allEntrys.itemSnapshotList.items
            Log.i("Entries", listEntries.toString())

            val list = if (searching) searchResults else listEntries
            item {
                TitleRow(head2 = "Amount", head3 = "Description", head4 = "Currency", head5 = "Date")
            }
            items(list) { entry ->
                EntryRow(entry, navController)
            }
            val refreshState = allEntrys.loadState.refresh
            if (refreshState is LoadState.Loading)
                item {
                    Row(verticalAlignment =  Alignment.CenterVertically) {
                        CircularProgressIndicator()
                    }
                }
            else if (refreshState is LoadState.Error)
                item {
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        val error = refreshState.error

                        Text("Error: ${error.localizedMessage}")
                        Button(onClick = { allEntrys.retry() }) {
                            Text("Retry")
                        }
                    }
                }

            val appendState = allEntrys.loadState.append
            if (appendState is LoadState.Loading)
                item {
                    Row(verticalAlignment =  Alignment.CenterVertically) {
                        Text("Loading...")
                        CircularProgressIndicator()
                    }
                }
            else if (appendState is LoadState.Error)
                item {
                    val error = appendState.error
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Subsequent data Error: ${error.localizedMessage}")
                        Button(onClick = { allEntrys.retry() }) {
                            Text("Retry")
                        }
                    }
                }
        }
    }
}
