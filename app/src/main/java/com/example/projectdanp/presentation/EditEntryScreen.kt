package com.example.projectdanp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectdanp.data.Entry
import com.example.projectdanp.data.EntryViewModel
import com.example.projectdanp.navigation.AppScreens
import com.example.projectdanp.presentation.components.InputValue
import com.example.projectdanp.presentation.components.TitleComponent
import java.time.LocalDateTime
import kotlin.random.Random

@Composable
fun EditEntryScreen(navController: NavController, entry: Entry, viewModel: EntryViewModel) {

    var amount by remember { mutableStateOf(entry.amount.toString()) }
    var description by remember { mutableStateOf(entry.description) }
    var currency by remember { mutableStateOf(entry.currency) }

    val onAmountTextChange = { text: String -> amount = text }
    val onDescriptionTextChange = { text: String -> description = text}
    val onCurrencyTextChange = { text: String -> currency = text}
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.deleteEntryById(entry.id)
                    navController.navigate(AppScreens.EntryListScreen.route)
                },
                backgroundColor = Color.Red,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove Icon")
            }
        }
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp)
                .verticalScroll(scrollState)

        ) {
            TitleComponent(title = "Expense detail")
            InputValue(
                title = "Amount",
                textState = amount,
                onTextChange = onAmountTextChange,
                keyboardType = KeyboardType.Number
            )
            InputValue(
                title = "Description ",
                textState = description,
                onTextChange = onDescriptionTextChange,
                keyboardType = KeyboardType.Text
            )
            InputValue(
                title = "Currency",
                textState = currency,
                onTextChange = onCurrencyTextChange,
                keyboardType = KeyboardType.Text
            )
            InputValue(
                title = "Date",
                textState = entry.day.toString().plus("/").plus(entry.month).plus("/").plus(entry.year),
                onTextChange = onCurrencyTextChange,
                keyboardType = KeyboardType.Text,
                enabled = false
            )
            Row(modifier = Modifier.padding(5.dp)) {
                val current = LocalDateTime.now()
                if (entry.id != 0) {
                    Spacer(
                        Modifier
                            .height(20.0.dp)
                            .width(20.dp))
                    Button(onClick = {
                        viewModel.updateEntry(
                            Entry(
                                entry.id,
                                day = current.dayOfMonth,
                                month = current.monthValue,
                                year = current.year,
                                amount = amount.toDouble(),
                                description = description,
                                currency = currency,
                                isIncome = amount.toDouble() > 0,
                            )
                        )
                        navController.navigate(AppScreens.EntryListScreen.route)
                    }) {
                        Text("Save")
                    }
                } else {
                    Button(onClick = {
                        viewModel.insertEntry(
                            Entry(
                                0,
                                day = current.dayOfMonth,
                                month = current.monthValue,
                                year = current.year,
                                amount = amount.toDouble(),
                                description = description,
                                currency = currency,
                                isIncome = amount.toDouble() > 0,
                            )
                        )
                        navController.navigate(AppScreens.EntryListScreen.route)
                    }) {
                        Text("Add")
                    }
                }
            }

        }
    }
}


