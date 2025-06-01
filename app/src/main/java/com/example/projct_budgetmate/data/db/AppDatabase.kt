import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projct_budgetmate.data.db.Category
import com.example.projct_budgetmate.data.db.CategoryDao
import com.example.projct_budgetmate.data.db.Converters
import com.example.projct_budgetmate.data.db.Transaction
import com.example.projct_budgetmate.data.db.TransactionDao

@Database(entities = [Category::class, Transaction::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
}

