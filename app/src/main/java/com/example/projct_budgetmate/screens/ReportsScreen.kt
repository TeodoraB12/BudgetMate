package com.example.projct_budgetmate.screens



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.projct_budgetmate.data.db.Category
import com.example.projct_budgetmate.model.Transaction
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

@Composable
fun ReportsScreen(
    transactions: List<Transaction>,
    categories: List<Category>
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Monthly Report (example)")
        Spacer(modifier = Modifier.height(8.dp))


        val total = transactions.sumOf { it.amount }
        Text(text = "Total amount: %.2f".format(total))

        Spacer(modifier = Modifier.height(8.dp))

        PieChartScreen()

    }
}
@Composable
fun PieChartScreen() {
    val pieEntries = listOf(
        PieEntry(60f, "Income"),
        PieEntry(40f, "Expenses")
    )

    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                val pieDataSet = PieDataSet(pieEntries, "Transactions")
                val pieData = PieData(pieDataSet)

                data = pieData
                description.isEnabled = false
                legend.isEnabled = true
                setUsePercentValues(true)
                invalidate()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
