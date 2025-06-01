package com.example.projct_budgetmate.model

data class Transaction(
    val category: String,
    val amount: Double,
    val date: String,
    val type: String, // "income" или "expense"
)