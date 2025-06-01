package com.example.projct_budgetmate.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projct_budgetmate.data.db.BudgetRepository
import com.example.projct_budgetmate.data.db.BudgetTransaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: BudgetRepository) : ViewModel() {

    private val _transactions = MutableStateFlow<List<BudgetTransaction>>(emptyList())
    val transactions: StateFlow<List<BudgetTransaction>> = _transactions

    init {
        loadTransactions()
    }

    fun loadTransactions() {
        viewModelScope.launch {
            val allTransactions = repository.getAllTransactions()
            _transactions.value = allTransactions
        }
    }

    fun addTransaction(transaction: BudgetTransaction) {
        viewModelScope.launch {
            repository.insertTransaction(transaction)
            loadTransactions()
        }
    }

    fun updateTransaction(transaction: BudgetTransaction) {
        viewModelScope.launch {
            repository.updateTransaction(transaction)
            loadTransactions()
        }
    }

    fun deleteTransaction(transaction: BudgetTransaction) {
        viewModelScope.launch {
            repository.deleteTransaction(transaction)
            loadTransactions()
        }
    }
}
