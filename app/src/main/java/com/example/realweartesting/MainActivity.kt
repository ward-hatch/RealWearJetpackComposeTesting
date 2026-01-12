package com.example.realweartesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.realweartesting.ui.theme.RealWearTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealWearTestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Greeting(
                                name = "Android"
                            )
                            Greeting2(
                                name = "Android"
                            )
                            Greeting3(commands = listOf("Test1", "Test2"))
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .semantics {
                contentDescription = "hf_use_description"
            }
    ) {
        Button(
            modifier = Modifier
                .semantics {
                    contentDescription = "Test"
                },
            onClick = {}
        ) {
            Text(name)
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .semantics {
                contentDescription = "hf_use_description"
            }
    ) {
        Button(
            modifier = Modifier
                .semantics {
                    contentDescription = "Test"
                },
            onClick = {}
        ) {
            Text(name)
            WearHfClickableContainerCommand(name)
        }
    }
}

@Composable
fun Greeting3(modifier: Modifier = Modifier, commands: List<String>){
    Box(
        modifier = modifier
            .semantics {
                contentDescription = "hf_use_description"
            }
    ) {
        Button(
            modifier = Modifier
                .semantics {
                    contentDescription = "Test"
                },
            onClick = {}
        ) {
            Text(commands.toString())
            WearHfClickableContainerCommands(commands){}
        }
    }
}

@Composable
fun WearHfClickableContainerCommands(
    commands: List<String>,
    onClick: () -> Unit,
    ) {
    Box(
        modifier = Modifier
            .focusProperties { canFocus = false }
            .clickable(onClick = onClick)
            .semantics {
                contentDescription = "hf_no_overlay|hf_commands: ${commands.joinToString(", ")}"
            }
    )
}

@Composable
fun WearHfClickableContainerCommand(command: String) {
    Text(text = command, modifier = Modifier.alpha(0f))

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RealWearTestingTheme {
        Greeting("Android")
    }
}