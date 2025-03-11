package com.example.lazashop

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazashop.routing.LazaShopRouter
import com.example.lazashop.routing.Screen
import com.example.lazashop.ui.screens.CartScreen
import com.example.lazashop.ui.screens.HomeScreen
import com.example.lazashop.ui.screens.WalletScreen
import com.example.lazashop.ui.screens.WishlistScreen


@Composable
fun LazaShopApp() {
    AppContent()
}

@Composable
private fun AppContent() {

    Scaffold(

        bottomBar = {
            BottomNavigationComponent()
        },
        content = { paddingValues ->
            MainScreenContainer(modifier = Modifier.padding(paddingValues))
        }
    )

}


@Composable
private fun MainScreenContainer(
    modifier: Modifier = Modifier,
) {
    val currentScreen by remember { LazaShopRouter.currentScreen }

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        when(currentScreen) {
            Screen.Home -> HomeScreen()
            Screen.Wishlist -> WishlistScreen()
            Screen.Cart -> CartScreen()
            Screen.Wallet -> WalletScreen()
        }
    }

}

// Use BottomNavigationComponent to explain Stateful Composable
@Composable
private fun BottomNavigationComponent(
    modifier: Modifier = Modifier
) {

    // Final Outcome
    val selectedItem = rememberSaveable { mutableStateOf(0) }

    val items = listOf(
        NavigationItem(0, navigationIcon = NavigationIcon(unselectedVectorResourceId = R.drawable.nav_home, selectedVectorResourceId = R.drawable.nav_home_2),
            Screen.Home
        ),

        NavigationItem(1, navigationIcon = NavigationIcon(unselectedVectorResourceId = R.drawable.nav_wishlist, selectedVectorResourceId = R.drawable.nav_wishlist_2),
        Screen.Wishlist
    ),

        NavigationItem(2, navigationIcon = NavigationIcon(unselectedVectorResourceId = R.drawable.nav_cart, selectedVectorResourceId = R.drawable.nav_cart_2),
        Screen.Cart
    ),
        NavigationItem(3, navigationIcon = NavigationIcon(unselectedVectorResourceId = R.drawable.nav_wallet, selectedVectorResourceId = R.drawable.nav_wallet_2),
        Screen.Wallet
        )
    )

    NavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {

        items.forEach{item ->
            BottomNavigationItem(
                selected = selectedItem.value == item.index,

                vectorResourceId = if (selectedItem.value == item.index) item.navigationIcon.selectedVectorResourceId
                        else item.navigationIcon.unselectedVectorResourceId,

                onNavItemClicked = {
                    selectedItem.value = item.index
                    LazaShopRouter.navigateTo(item.screen)
                }
            )

        }
    }

}


@Composable
private fun RowScope.BottomNavigationItem(
    selected: Boolean,
    @DrawableRes vectorResourceId: Int,
    onNavItemClicked: () -> Unit = {}
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = vectorResourceId),
                contentDescription = ""
            )
        },
        colors = NavigationBarItemDefaults.colors().copy(
            selectedIndicatorColor = Color.Transparent
        ),
        selected = selected,
        onClick = {
            onNavItemClicked.invoke()
        }
    )
}

private data class NavigationItem(
    val index: Int,
    val navigationIcon: NavigationIcon,
    val screen: Screen
)

private data class NavigationIcon(
    @DrawableRes val unselectedVectorResourceId: Int,
    @DrawableRes val selectedVectorResourceId: Int
)


@Preview(showBackground = true)
@Composable
fun BottonNavigationComponentPreview(modifier: Modifier = Modifier) {
    BottomNavigationComponent()
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationItemPreview() {
    Row(modifier = Modifier.wrapContentSize()) {
        BottomNavigationItem(selected = true, vectorResourceId = R.drawable.nav_home)
    }
}