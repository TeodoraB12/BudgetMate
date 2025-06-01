package com.example.projct_budgetmate

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.projct_budgetmate.model.Transaction
import java.util.Date
import java.util.Locale


@Composable
fun AddTransactionScreen(onAddTransaction: (Transaction) -> Unit) {
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("expense") } // или "income"

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { type = "income" },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text("Income")
            }
            Button(
                onClick = { type = "expense" },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text("Expense")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val amountDouble = amount.toDoubleOrNull()
                if (category.isNotBlank() && amountDouble != null) {
                    val transaction = Transaction(
                        category = category,
                        amount = amountDouble,
                        date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date()),
                        type = type
                    )
                    onAddTransaction(transaction)
                    // Чистење на полињата по додавање
                    category = ""
                    amount = ""
                    type = "expense"
                } else {
                    // Можеш да додадеш порака за грешка ако сакаш
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Transaction")
        }
    }
}
