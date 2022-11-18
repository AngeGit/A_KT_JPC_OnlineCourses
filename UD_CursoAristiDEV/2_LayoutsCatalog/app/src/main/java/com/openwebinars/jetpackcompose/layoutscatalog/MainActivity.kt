package com.openwebinars.jetpackcompose.layoutscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openwebinars.jetpackcompose.jetpackcomposecatalog.MainScreen
import com.openwebinars.jetpackcompose.layoutscatalog.ui.theme.LayoutsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCatalogTheme {
                MainScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutsCatalogTheme {
        MainScreen()
    }
}