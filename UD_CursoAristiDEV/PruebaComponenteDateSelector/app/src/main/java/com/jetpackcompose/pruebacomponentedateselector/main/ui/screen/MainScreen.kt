package com.jetpackcompose.pruebacomponentedateselector.main.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DatePickerSelectorBox
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DatePickerSelectorVM

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {

    val dtpickerVM = DatePickerSelectorVM(2)

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(8.dp))
        DatePickerSelectorBox(dtpickerVM)
    }


}