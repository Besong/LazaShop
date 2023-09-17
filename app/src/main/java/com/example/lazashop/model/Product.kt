package com.example.lazashop.model

import androidx.annotation.DrawableRes
import com.example.lazashop.R

data class Product(val name: String, val price: Int, @DrawableRes val image: Int)

val products = listOf(
    Product("Nike Sportswear Club \nFleece", 99, R.drawable.image1),
    Product("Trail Running Jacket Nike Windrunner", 99, R.drawable.image2),
    Product("Training Top Nike Sport \nClash", 99, R.drawable.image3),
    Product("Trail Running Jacket Nike Windrunner", 99, R.drawable.image4)
)

