package com.example.androidminiproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidminiproject.compasables.BranchCard
import com.example.androidminiproject.models.Branch
import com.example.androidminiproject.models.BranchType
import com.example.androidminiproject.ui.theme.AndroidMiniProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMiniProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          BranchCard(Branch(
              id = 0,
              name = "Test",
              type = BranchType.VIRTUAL,
              address = "Kuwait City",
              phone = "22222222",
              hours = "8AM-3PM",
              locationURL = "goo.gl/rgergba",
              imageUri = null,), modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidMiniProjectTheme {
        Greeting("Android")
    }
}