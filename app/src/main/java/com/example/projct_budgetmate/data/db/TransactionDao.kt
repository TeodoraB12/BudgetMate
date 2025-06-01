package com.example.projct_budgetmate.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    suspend fun getAllTransactions(): List<BudgetTransaction>

    @Query("SELECT * FROM transactions WHERE date BETWEEN :start AND :end ORDER BY date DESC")
    suspend fun getTransactionsBetweenDates(start: Long, end: Long): List<BudgetTransaction>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: BudgetTransaction): Long

    @Update
    suspend fun updateTransaction(transaction: BudgetTransaction)

    @Delete
    suspend fun deleteTransaction(transaction: BudgetTransaction)
}
