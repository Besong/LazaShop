package com.example.lazashop.routing

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.lazashop.R

/**
 * Class representing the screens in the the app
 */

sealed class Screen(@StringRes val titleResId: Int) {

    object Home: Screen(R.string.home)

    object Wishlist: Screen(R.string.wishlist)

    object Cart: Screen(R.string.cart)

    object Wallet: Screen(R.string.wallet)
}

object LazaShopRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(
        Screen.Home
    )

    private var previousScreen: MutableState<Screen> = mutableStateOf(
        Screen.Home
    )

    fun navigateTo(destination: Screen) {
        previousScreen.value = currentScreen.value
        currentScreen.value = destination
    }

    fun goBack() {
        currentScreen.value = previousScreen.value
    }
}