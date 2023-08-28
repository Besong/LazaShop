package com.example.lazashop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazashop.theme.Inter_Bold
import com.example.lazashop.theme.LazaShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazaShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val sizeInSp = with(LocalDensity.current) {34.toSp()}
    val heightInSp = with(LocalDensity.current) {37.toSp()}

    Image(
        painter = painterResource(id = R.drawable.adidas),
        contentDescription = "Cart"
    )

//    Text(
//        text = "Hello",
//        modifier = modifier,
//        style = TextStyle(
//            fontFamily = FontFamily(Inter_Bold),
//            fontSize = sizeInSp,
//            lineHeight = heightInSp
//        )
//    )





}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazaShopTheme {
        Greeting("Android")
    }
}