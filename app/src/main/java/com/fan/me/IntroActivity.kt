package com.fan.me

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )

        setContent {
            Intro()
        }
    }

    @Preview
    @Composable
    fun Intro() {
        ConstraintLayout(
            modifier =
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White)
        )
        {
            val (img, img2, logo, today, text) = createRefs()

            Image(painter = painterResource(id = R.drawable.top_tight),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(img) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    })

            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .padding(32.dp)
                    .constrainAs(logo) {
                        end.linkTo(parent.end)
                        top.linkTo(img.bottom)
                    })
            Text(
                text = "Elevate Your \n" + "learning Experience",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(today.top)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.bottom_left),
                contentDescription = "",
                modifier = Modifier.constrainAs(img2) {
                    start.linkTo(parent.start)
                    bottom.linkTo(
                        parent.bottom
                    )
                }
            )
            Image(
                painter = painterResource(id = R.drawable.today),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(today) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        top.linkTo(text.bottom)
                        bottom.linkTo(img2.top)
                    })
        }
    }
}
