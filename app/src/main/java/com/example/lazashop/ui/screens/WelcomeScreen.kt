package com.example.lazashop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazashop.R
import com.example.lazashop.model.Product
import com.example.lazashop.model.products
import com.example.lazashop.theme.Inter_Regular
import com.example.lazashop.theme.Inter_semiBold
import com.example.lazashop.theme.blackColor
import com.example.lazashop.theme.color01
import com.example.lazashop.theme.color02
import com.example.lazashop.theme.purpleColor
import com.example.lazashop.ui.components.ArrivalItem
import com.example.lazashop.ui.components.BrandItem
import com.example.lazashop.ui.components.CustomIcon
import com.example.lazashop.ui.components.SectionHeader
import com.example.lazashop.ui.components.VerticalGrid

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
            WelcomeScreenContent(modifier = modifier)
        }
}

@Composable
private fun WelcomeScreenContent(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.verticalScroll(state = rememberScrollState())
    ) {

        TopAppBar()

        Greeting()

        Search()

        ChooseBrand()

        NewArrival()
    }
}
@Composable
private fun TopAppBar(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxWidth()
    ) {

        // Menu Icon
        CustomIcon(
            modifier = modifier
                .padding(10.dp)
                .align(Alignment.TopStart),
            backgroundShape = CircleShape,
            icon =R.drawable.menu,
            size = 40.dp,
            color = color02)

        // Cart Icon
        CustomIcon(
            modifier = modifier
                .padding(10.dp)
                .align(Alignment.TopEnd),
            backgroundShape = CircleShape,
            icon = R.drawable.cart,
            size = 40.dp,
            color = color02)
    }
}

@Composable
private fun Greeting(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(start = 10.dp)
    ) {

        Text(
            text = "Hello",
            modifier = modifier,
            style = TextStyle(
                fontFamily = FontFamily(Inter_semiBold),
                fontSize = 28.sp,
                lineHeight = 31.sp,
                color = blackColor
            ),
        )

        Text(
            text = "Welcome to Laza.",
            modifier = modifier,
            style = TextStyle(
                fontFamily = FontFamily(Inter_Regular),
                fontSize = 15.sp,
                lineHeight = 31.sp,
                color = color01
            )
        )
    }

}

@Composable
private fun Search(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier
) {

    // modifier -> For parent composable
    // contentModifier -> For children composable
    
    val text = remember { mutableStateOf("Search...") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Row(
            modifier = contentModifier
                .size(width = 275.dp, height = 50.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = color02)
                .padding(horizontal = 15.dp, vertical = 15.dp)

        ) {
            Image(
                modifier = contentModifier.padding(end = 10.dp),
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon"
            )

            BasicTextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                textStyle = TextStyle(
                    fontFamily = FontFamily(Inter_Regular),
                    fontSize = 15.sp,
                    lineHeight = 16.5.sp,
                    color = color01
                )
            )
        }

        Spacer(modifier = Modifier.padding(end = 15.dp))

        CustomIcon(
            modifier = modifier,
            backgroundShape = RoundedCornerShape(10.dp),
            icon = R.drawable.voice,
            size = 50.dp,
            color = purpleColor
        )
    }


}

@Composable
private fun ChooseBrand(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {

        SectionHeader(name = "Choose Brand", modifier = Modifier)


        // BrandList
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            BrandItem(
                brand = R.string.adidas,
                icon = R.drawable.adidas,
                modifier = Modifier.padding(start = 5.dp))

            BrandItem(
                brand = R.string.nike,
                icon = R.drawable.nike,
                modifier = Modifier)

            BrandItem(
                brand = R.string.fila,
                icon = R.drawable.fila,
                modifier = Modifier)

            BrandItem(
                brand = R.string.puma,
                icon = R.drawable.puma,
                modifier = Modifier)

        }
    }


}

@Composable
private fun NewArrival(
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        SectionHeader(name = "New Arrival", modifier = Modifier)

        ProductGrid(products = products)
    }
}

@Composable
private fun ProductGrid(products: List<Product>) {

    VerticalGrid {
        products.forEach { product ->
            ArrivalItem(product = product, modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
@Preview(showBackground = true)
@Composable
fun WelcomeScreenContentPreview() {
    WelcomeScreenContent()
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    Search()
}

@Preview(showBackground = true)
@Composable
fun ChooseBrandPreview() {
    ChooseBrand()
}

@Preview(showBackground = true)
@Composable
fun NewArrivalPreview() {
    NewArrival()
}
