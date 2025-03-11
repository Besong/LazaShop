package com.example.lazashop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lazashop.theme.Inter_semiBold
import com.example.lazashop.theme.blackColor

@Composable
fun WalletScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "This is the Wallet Screen",
            style = TextStyle(
                fontFamily = FontFamily(Inter_semiBold),
                fontSize = 22.sp,
                lineHeight = 31.sp,
                color = blackColor
            ),
        )
    }
}

@Preview
@Composable
fun WalletScreenPreview(modifier: Modifier = Modifier) {
    WalletScreen()
}