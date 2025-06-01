package com.example.projct_budgetmate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projct_budgetmate.model.Transaction

@Composable
fun TransactionListScreen(initialTransactions: List<Transaction>) {
    var transactions by remember { mutableStateOf(initialTransactions) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(transactions) { transaction ->
            TransactionItem(
                transaction = transaction,
                onDelete = {

                    transactions = transactions.toMutableList().apply {
                        remove(transaction)
                    }
                }
            )
        }
    }
}

@Composable
fun TransactionItem(
    transaction: Transaction,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Category: ${transaction.category}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Amount: ${transaction.amount}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Date: ${transaction.date}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Type: ${transaction.type}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onDelete) {
                Text(text = "Delete")
            }
        }
    }
}

