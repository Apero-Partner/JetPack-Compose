package com.sudo248.jpcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sudo248.jpcompose.ui.navigation.Navigation
import com.sudo248.jpcompose.ui.theme.JPComposeTheme
import com.sudo248.jpcompose.ui.theme.title

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityScreen() {
    JPComposeTheme {
        // A surface container using the 'background' color from the theme
        Navigation()
    }
}
