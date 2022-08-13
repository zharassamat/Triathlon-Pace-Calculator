package sj.alashalemi.triathlonpacecalculator.ui.screens.run

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sj.alashalemi.triathlonpacecalculator.R
import sj.alashalemi.triathlonpacecalculator.ui.theme.TriathlonPaceCalculatorTheme

@Composable
fun RunScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DistanceField(modifier)
        TimeField(modifier)
        PaceField(modifier)
    }
}

@Composable
fun DistanceField(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.distance),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            fontSize = 14.sp
        )

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = text,
            shape = RoundedCornerShape(36.dp),
            textStyle = TextStyle(color = Color.Black),
            onValueChange = { text = it }
        )
    }
}

@Composable
fun TimeField(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.time),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            fontSize = 14.sp
        )

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = text,
            shape = RoundedCornerShape(36.dp),
            textStyle = TextStyle(color = Color.Black),
            onValueChange = { text = it }
        )
    }
}

@Composable
fun PaceField(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.pace),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            fontSize = 14.sp
        )

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = text,
            shape = RoundedCornerShape(36.dp),
            textStyle = TextStyle(color = Color.Black),
            onValueChange = { text = it }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview("Address Screen on Pixel 3", device = Devices.PIXEL_3)
@Composable
fun AddressScreenPreview() {
    TriathlonPaceCalculatorTheme {
        RunScreen()
    }
}
