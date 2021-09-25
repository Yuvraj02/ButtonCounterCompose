package com.reckonco.buttoncounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.reckonco.buttoncounter.ui.theme.ButtonCounterTheme

private lateinit var viewModel: MainActivityViewModel
private lateinit var viewModelFactory: MainActivityViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        setContent {
            ButtonCounterTheme {

                // A surface container using the 'background' color from the theme
                MainScreen()
                }
            }
        }
    }

@Composable
fun MainScreen(){

  //  val increment : MutableState<Int> = remember{mutableStateOf(0)}

    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
            TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),value = viewModel.query.value, onValueChange = {
                viewModel.query.value= it

            })
            Text(text = viewModel.increment.value.toString(),modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),fontSize = 24.sp)
            FloatingActionButton(onClick = { viewModel.AddNum()}) {
                Text(text = "ADD",color = Color.White,fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    ButtonCounterTheme {
        MainScreen()
    }
}
