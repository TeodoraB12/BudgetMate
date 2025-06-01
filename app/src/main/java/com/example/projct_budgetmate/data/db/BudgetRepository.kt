package com.example.projct_budgetmate.data.db

class BudgetRepository(
    private val categoryDao: CategoryDao,
    private val transactionDao: TransactionDao
) {
    suspend fun getAllCategories() = categoryDao.getAllCategories()
    suspend fun insertCategory(category: Category) = categoryDao.insertCategory(category)
    suspend fun updateCategory(category: Category) = categoryDao.updateCategory(category)
    suspend fun deleteCategory(category: Category) = categoryDao.deleteCategory(category)

    suspend fun getAllTransactions() = transactionDao.getAllTransactions()
    suspend fun getTransactionsBetweenDates(start: Long, end: Long) = transactionDao.getTransactionsBetweenDates(start, end)
    suspend fun insertTransaction(transaction: Transaction) = transactionDao.insertTransaction(transaction)
    suspend fun updateTransaction(transaction: Transaction) = transactionDao.updateTransaction(transaction)
    suspend fun deleteTransaction(transaction: Transaction) = transactionDao.deleteTransaction(transaction)
}
