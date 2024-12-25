package com.fan.me

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 设置窗口全屏布局，沉浸式状态栏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = false

        enableEdgeToEdge()

        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.isAppearanceLightStatusBars = false
        windowInsetsController.isAppearanceLightNavigationBars = false

        setContent {
            MyUi()
        }
    }
}

@Preview
@Composable
fun MyUi() {

    val scaffoldState = rememberNavController()
    val navController = rememberNavController()
    val cartPainter = painterResource(id = R.drawable.shopping_cart)

    Scaffold(
        bottomBar = {
            MyBottomBur()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                contentColor = Color.White,
                backgroundColor = Color(android.graphics.Color.parseColor("#fa5b52")),
                modifier = Modifier.offset(y = (50).dp)
            ) {
                Icon(
                    painter = cartPainter,
                    contentDescription = "add",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NameProfile()
            Title()
            Buttons()
            Banners()
        }
    }
}

@Composable
fun NameProfile() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(top = 32.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.user_1),
            contentDescription = null,
            modifier = Modifier
                .width(55.dp)
                .height(55.dp)
                .clickable {})
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
                .height(40.dp)
        ) {
//        .align(alignment = Alignment.CenterVertically)
            Text(
                text = "Hi Xiao Fan",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}

@Composable
fun Title() {
    Text(
        "What Would like to\n learn today?",
        color = Color.Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    )
}

@Composable
fun Buttons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(0.5f)
                .height(170.dp)
                .padding(end = 12.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#37c9bb")),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_1),
                contentDescription = null,
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
            )
            Text(
                text = "Developing",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .height(170.dp)
                .padding(start = 12.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#ff9643")),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_2),
                contentDescription = null,
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
            )
            Text(
                text = "Designing",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(0.5f)
                .height(170.dp)
                .padding(end = 12.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#f36095")),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_3),
                contentDescription = null,
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
            )
            Text(
                text = "AI & ML",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .height(170.dp)
                .padding(start = 12.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#389ef2")),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_4),
                contentDescription = null,
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
            )
            Text(
                text = "Explorer",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun Banners() {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Popular Courses", color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "See all", color = Color.Black,
            fontSize = 16.sp,
        )
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .height(120.dp)
            .border(
                1.dp,
                Color(android.graphics.Color.parseColor("#fbe6dd")),
                shape = RoundedCornerShape(25.dp)
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.White,
                        Color(android.graphics.Color.parseColor("#fbe6dd"))
                    )
                ),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        val (img, text) = createRefs()
        Image(
            modifier = Modifier
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .padding(end = 16.dp),
            painter = painterResource(id = R.drawable.ai),
            contentDescription = ""
        )
        Text(
            text = "Advanced certificate\n" + "Program in AI",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
fun MyBottomBur() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    val selectedItem = remember { mutableStateOf("Profile") }

    NavigationBar(
        containerColor = Color(android.graphics.Color.parseColor("#f8f8f8")),
        tonalElevation = 3.dp
    ) {
        bottomMenuItemsList.forEachIndexed { index, item ->
            if (index == 2) {
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { },
                    enabled = false
                )
            }
            NavigationBarItem(
                selected = (selectedItem.value == item.label),
                onClick = {
                    selectedItem.value = item.label
                    Toast.makeText(contextForToast, item.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                },
                label = { Text(text = item.label, modifier = Modifier.padding(top = 14.dp)) },
                alwaysShowLabel = false,
                enabled = true
            )
        }
    }
}

data class BottomMenuItem(val label: String, val icon: Painter)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    var bottomMenuItemList = arrayListOf<BottomMenuItem>()

    bottomMenuItemList.addAll(
        listOf(
            BottomMenuItem(
                label = "Home",
                icon = painterResource(id = R.drawable.bottom_btn1)
            ),
            BottomMenuItem(
                label = "Profile",
                icon = painterResource(id = R.drawable.bottom_btn2)
            ),
            BottomMenuItem(
                label = "Support",
                icon = painterResource(id = R.drawable.bottom_btn3)
            ),
            BottomMenuItem(
                label = "Setting",
                icon = painterResource(id = R.drawable.bottom_btn4)
            )
        )
    )
    return bottomMenuItemList
}