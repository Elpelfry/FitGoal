package edu.ucne.fitgoal.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Text(
        text = "Bienvenido a Home",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}