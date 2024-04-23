package com.example.materialcomposecomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialcomposecomponents.ui.theme.MaterialComposeComponentsTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialComposeComponentsTheme {
        MyScaffold()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    var presses by remember { mutableStateOf<Int>(0) }

    Scaffold(
        topBar = {
                 TopAppBar(
                     colors = mediumTopAppBarColors(
                         containerColor = MaterialTheme.colorScheme.primaryContainer,
                         titleContentColor = MaterialTheme.colorScheme.primary
                     ),
                     title = { Text(text = "Top App bar")}
                 )
        },
        bottomBar = {
                    BottomAppBar(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary
                    ) {
                        Text(
                            text = "Bottom App bar",
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { presses++ }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add button"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
                    
                    It also contains some basic inner content, such as this text.
                    
                    You have pressed the floating action button $presses times.
                """.trimIndent()
            )
        }
    }
}