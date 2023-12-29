package com.lucasgmeneses.medi.alert.view.pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasgmeneses.medi.alert.R
import com.lucasgmeneses.medi.alert.model.Medicine
import com.lucasgmeneses.medi.alert.view.pages.ui.theme.MediAlertTheme
import com.lucasgmeneses.medi.alert.view.pages.ui.theme.fontRighteous

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMedicinePage(){
    val medicines: List<Medicine> = listOf(
        Medicine("Paracetamol", "1 pirula", 8, 20),
        Medicine("Fluxetina", "1 pirula", 8, 5),
        Medicine("Dipirona", "1 pirula", 8, 15))

    Scaffold(  topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(stringResource(id = R.string.app_name),
                fontFamily = fontRighteous
                )
            }
        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick ={} ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(medicines) { medicine ->
                CardMedicine(medicine)
            }
        }
    }
}
@Composable
fun CardMedicine(medicine: Medicine = Medicine("Paracetamol", "1 pirula", 8, 20)){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = medicine.name,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MediAlertTheme {
        ListMedicinePage()
    }
}