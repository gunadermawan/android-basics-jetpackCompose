package com.gunder.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gunder.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun OnBoardingScreen(modifier: Modifier = Modifier) {
    var shouldShowBoarding by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text("welcome to jetpack compose!")
        Button(
            onClick = { shouldShowBoarding = false },
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
private fun OnBoardingPreview() {
    ComposeBasicsTheme {
        OnBoardingScreen()
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("world", "Android")
) {
    Surface(
        modifier = modifier.padding(vertical = 4.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        MyApp()
    }
}