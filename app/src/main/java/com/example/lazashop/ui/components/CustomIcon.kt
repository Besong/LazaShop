package com.example.lazashop.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lazashop.R
import com.example.lazashop.theme.color02
import com.example.lazashop.theme.color03

@Composable
fun CustomIcon(
    @DrawableRes icon: Int,
    backgroundShape: Shape,
    size: Dp,
    color: Color,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(backgroundShape)
            .background(color = color)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = modifier.align(Alignment.Center))
    }
}
@Preview(showBackground = true)
@Composable
fun CustomCartIconPreview() {
    CustomIcon(
        icon = R.drawable.cart,
        backgroundShape = CircleShape,
        size = 40.dp,
        color = color02,
        modifier = Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CustomAdidasIconPreview() {
    CustomIcon(
        icon = R.drawable.adidas,
        backgroundShape = RoundedCornerShape(10.dp),
        size = 40.dp,
        color = color03,
        modifier = Modifier
    )
}
