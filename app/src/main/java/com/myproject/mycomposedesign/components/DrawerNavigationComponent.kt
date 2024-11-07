package com.myproject.mycomposedesign.components


import androidx.collection.intSetOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.myproject.mycomposedesign.R
import com.myproject.mycomposedesign.model.NavigationItems
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerComponent(
    drawerState: DrawerState,
    navController: NavController
) {
    val items = listOf(
        NavigationItems(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "Profile"
        ),
        NavigationItems(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "Home"
        ),
        NavigationItems(
            title = "Setting",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "Setting"
        ),
        NavigationItems(
            title = "Favorites",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            route = "Favorites"
        ),
        NavigationItems(
            title = "Games",
            selectedIcon = Icons.Filled.Games,
            unselectedIcon = Icons.Outlined.Games,
            route = "Games"
        ),
        NavigationItems(
            title = "Message",
            selectedIcon = Icons.Filled.Message,
            unselectedIcon = Icons.Outlined.Message,
            route = "Message"
        ),
        NavigationItems(
            title = "Sign Out",
            selectedIcon = Icons.Filled.Logout,
            unselectedIcon = Icons.Outlined.Logout,
            route = "Sign Out"
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .background(Color(0xFF3F5A9E))
                    .width(240.dp)
                    .wrapContentHeight()
            ) {
                NavBarHeader(drawerState = drawerState)
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.White,
                            unselectedContainerColor = Color(0xFF3F5A9E),
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.White,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.White

                        ),
                        label = { Text(text = item.title) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                            scope.launch { drawerState.close() }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon

                                } else item.unselectedIcon,
                                contentDescription = item.title,
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .background(Color(0xFF3F5A9E))
                            .padding(5.dp)


//                        modifier = Modifier.padding(NavigationBarItemDefaults.ItemPadding)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }

        }
    }
}

@Composable
fun NavBarHeader(drawerState: DrawerState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFF3F5A9E))
            .padding(bottom = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.profile), contentDescription = "profile",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .padding(top = 20.dp)
            )
            Text(
                text = "Jayshree Shirsat",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                color = Color.White,
                text = "Jayshreeshirsat@gmail.com",
            )
        }
        IconButton(
            onClick = { /* Handle close action here */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.cross_icon),
                contentDescription = "Close",
                modifier = Modifier.size(25.dp),
            )
        }
    }
}


@Preview
@Composable
fun NavigationDrawerComponentPreview() {
//    NavigationDrawerComponent()
}