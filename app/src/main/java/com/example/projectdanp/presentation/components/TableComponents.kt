package com.example.projectdanp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectdanp.data.Entry
import com.example.projectdanp.data.EntryViewModel
import com.example.projectdanp.navigation.AppScreens

@Composable
fun TitleRow(head2: String, head3: String, head4: String, head5: String) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            head2, color = Color.White,
            modifier = Modifier
                .weight(0.2f)
        )
        Text(
            head3, color = Color.White,
            modifier = Modifier.weight(0.2f)
        )
        Text(
            head4, color = Color.White,
            modifier = Modifier.weight(0.2f)
        )
        Text(
            head5, color = Color.White,
            modifier = Modifier.weight(0.2f)
        )
    }
}

@Composable
fun EntryRow(entry: Entry? = null, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("entry", entry?.id)
                navController.navigate(AppScreens.EditEntryScreen.route)
            }
    ) {
        if (entry != null){
            if (entry.isIncome){
                Text(entry.amount.toString(), modifier = Modifier.weight(0.2f), color = Color.Green)
            }else{
                Text(entry.amount.toString(), modifier = Modifier.weight(0.2f), color = Color.Red)
            }
            Text(entry.description, modifier = Modifier.weight(0.2f))
            Text(entry.currency, modifier = Modifier.weight(0.2f))
            Text(
                entry.day.toString().plus("/").plus(entry.month).plus("/").plus(entry.year),
                modifier = Modifier.weight(0.2f))
        }
    }
}


@Composable
fun InputValue(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType,
    enabled: Boolean = true
) {
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier.padding(0.dp, 5.dp),
        textStyle = TextStyle(
            fontSize = 14.sp
        ),
        enabled = enabled
    )
}