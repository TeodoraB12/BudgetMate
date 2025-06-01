package com.example.projct_budgetmate.data.db

import androidx.room.*

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    suspend fun getAllTransactions(): List<`Transaction`>

    @Query("SELECT * FROM transactions WHERE date BETWEEN :start AND :end ORDER BY date DESC")
    suspend fun getTransactionsBetweenDates(start: Long, end: Long): List<`Transaction`>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: `Transaction`): Long

    @Update
    suspend fun updateTransaction(transaction: `Transaction`)

    @Delete
    suspend fun deleteTransaction(transaction: `Transaction`)
}
