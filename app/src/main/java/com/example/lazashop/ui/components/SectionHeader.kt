package com.example.lazashop.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazashop.theme.Inter_Medium
import com.example.lazashop.theme.Inter_Regular
import com.example.lazashop.theme.blackColor
import com.example.lazashop.theme.color01


/**
 * Composable function for building section headers.
 */
@Composable
fun SectionHeader(
    name: String,
    modifier: Modifier
) {

    Box(
        modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {

        Text(
            text = name,
            modifier = modifier.align(Alignment.TopStart),
            style = TextStyle(
                fontFamily = FontFamily(Inter_Medium),
                fontSize = 17.sp,
                lineHeight = 18.7.sp,
                color = blackColor
            ),
        )

        Text(
            text = "View All",
            modifier = modifier
                .align(Alignment.TopEnd)
                .padding(top = 2.dp, end = 2.dp),
            style = TextStyle(
                fontFamily = FontFamily(Inter_Regular),
                fontSize = 13.sp,
                lineHeight = 14.3.sp,
                color = color01
            ),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview() {
    SectionHeader(
        name = "Choose Brand",
        modifier = Modifier
    )

}