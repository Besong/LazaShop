package com.example.lazashop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazashop.R
import com.example.lazashop.model.Product
import com.example.lazashop.model.products
import com.example.lazashop.theme.Inter_Medium
import com.example.lazashop.theme.Inter_semiBold
import com.example.lazashop.theme.blackColor
import com.example.lazashop.theme.color02

@Composable
fun ArrivalItem(
    product: Product,
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(10.dp)
    ) {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = color02)
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = "",
                modifier = modifier.align(Alignment.Center)
            )

            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "",
                modifier = modifier
                    .padding(10.dp)
                    .align(Alignment.TopEnd)
            )
        }

        Text(
            text = product.name,
            modifier = modifier.padding(top = 4.dp),
            style = TextStyle(
                fontFamily = FontFamily(Inter_Medium),
                fontSize = 11.sp,
                lineHeight = 15.4.sp,
                color = blackColor
            ),
            maxLines = 2,
            overflow = TextOverflow.Clip
        )

        Text(
            text = "$${product.price}",
            modifier = modifier.padding(top = 4.dp),
            style = TextStyle(
                fontFamily = FontFamily(Inter_semiBold),
                fontSize = 13.sp,
                lineHeight = 14.3.sp,
                color = blackColor
            ),
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ArrivalItemPreview() {
    ArrivalItem(
        product = products[0],
        modifier = Modifier
    )

}