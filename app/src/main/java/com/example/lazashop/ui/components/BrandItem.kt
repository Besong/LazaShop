package com.example.lazashop.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazashop.R
import com.example.lazashop.theme.Inter_Medium
import com.example.lazashop.theme.blackColor
import com.example.lazashop.theme.color02
import com.example.lazashop.theme.color03

@Composable
fun BrandItem(
    @StringRes brand: Int,
    @DrawableRes icon: Int,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(5.dp)
            .size(width = 115.dp, height = 50.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(color = color02)
    ) {

        CustomIcon(
            modifier = modifier,
            backgroundShape = RoundedCornerShape(10.dp),
            icon = icon,
            size = 40.dp,
            color = color03
        )

        Text(
            text = stringResource(id = brand),
            modifier = modifier,
            style = TextStyle(
                fontFamily = FontFamily(Inter_Medium),
                fontSize = 15.sp,
                lineHeight = 16.5.sp,
                color = blackColor
            )
        )

    }
}

@Preview
@Composable
fun BrandItemPreview() {
    BrandItem(
        brand = R.string.adidas,
        icon = R.drawable.adidas,
        modifier = Modifier
    )
}