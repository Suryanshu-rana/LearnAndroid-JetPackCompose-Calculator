package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculate()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculate(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf("0")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = "Calculator", fontSize = 30.sp)
        var text1 by remember { mutableStateOf("") }
        var text2 by remember { mutableStateOf("") }
        Column(horizontalAlignment = Alignment.CenterHorizontally,) {
            TextField(
                value = text1,
                onValueChange = { newText ->
                    text1 = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Enter text") },
                modifier = Modifier.padding(10.dp,50.dp,10.dp,5.dp)
            )
            TextField(
                value = text2,
                onValueChange = { newText ->
                    text2 = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Enter text") }
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(30.dp)) {
            Button(onClick = { result = addition(text1.toLong(), text2.toLong()).toString() }) {
                Text(text = "+")
            }
            Button(onClick = { result = subtraction(text1.toLong(), text2.toLong()).toString() }) {
                Text(text = "-")
            }
            Button(onClick = { result = division(text1.toLong(), text2.toLong()).toString() }) {
                Text(text = "/")
            }
            Button(onClick = { result = multiplication(text1.toLong(), text2.toLong()).toString() }) {
                Text(text = "*")
            }
        }
        
        Text(text = "Output : "+result, fontSize = 25.sp)
    }
}

fun addition(Input1:Long,Input2:Long): Long{
    return Input1 + Input2
}
fun subtraction(Input1:Long,Input2:Long): Long{
    return Input1 - Input2
}
fun division(Input1:Long,Input2:Long): Long{
    return Input1 / Input2
}
fun multiplication(Input1:Long,Input2:Long): Long{
    return Input1 * Input2
}
