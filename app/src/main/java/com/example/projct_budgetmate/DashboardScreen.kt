import ads_mobile_sdk.h4
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.projct_budgetmate.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieData




@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.welcome_message),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))


        PieChartScreen()

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = { /* Navigacija до AddTransaction Screen */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.add_transaction))
        }
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
                invalidate()  // го освежува графикот
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}

