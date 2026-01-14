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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.example.realweartesting.ui.theme.RealWearTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealWearTestingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .semantics { contentDescription = "hf_no_overlay|hf_no_number|hf_use_description" }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Greeting(
                                text = "Android 1",
                                command = "Test 1",
                                onClick = { println("Greeting 1 clicked") },
                            )
                            Greeting(
                                text = "Android 2",
                                command = "Test 2",
                                onClick = { println("Greeting 2 clicked") },
                            )
                            MultipleGreetings(
                                text = "Android 3",
                                commands = listOf("Test 3", "Test 4"),
                                onClick = { println("MultipleGreetings clicked") }
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    text: String,
    command: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        WearHfClickableContainerCommand(command)
        Text(text)
    }
}

@Composable
fun MultipleGreetings(
    text: String,
    commands: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(
            text = text,
            modifier = Modifier
                .focusProperties { canFocus = false }
                .clickable(onClick = onClick)
                .semantics {
                    contentDescription = "hf_commands: ${commands.joinToString(", ")}"
                },
        )
    }
}

@Composable
fun WearHfClickableContainerCommand(
    command: String,
) {
    Text(text = command, modifier = Modifier.minSize().alpha(0f))
}

private fun Modifier.minSize() = this.then(Modifier.size(1.dp))
