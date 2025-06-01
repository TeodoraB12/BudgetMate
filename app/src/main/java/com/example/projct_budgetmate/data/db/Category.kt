package com.example.projct_budgetmate.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: CategoryType, // Income or Expense
)

enum class CategoryType {
    INCOME,
    EXPENSE
}
