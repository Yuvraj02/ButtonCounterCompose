package com.reckonco.buttoncounter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal:Int) : ViewModel(){
    var increment = MutableLiveData<Int>()

    init {
        increment.value = startingTotal
    }

    var query =  mutableStateOf("")
//   val updatedVal:(String)->Unit = {newValue->query.value = newValue}

//   fun getUpdatedCount():Int{
//       return increment.value++
//   }

   fun AddNum(){
       /*   Algorithm :
       1) Get the value from the text field
       2) Append the value to the increment value
        */
        increment.value = (increment.value)?.plus(query.value.toInt())
   }

}