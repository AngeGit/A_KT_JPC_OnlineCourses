package com.jetpackcompose.pruebacomponentedateselector.dateselector.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerSelectorBox(dtPickerVM: DatePickerSelectorVM) {
    val pickerBoxDesde: String by dtPickerVM.dtPickerBoxDesde.observeAsState(initial="")
    val pickerBoxHasta: String by dtPickerVM.dtPickerBoxHasta.observeAsState(initial = "")
    val loadDatePickerDialog: Boolean by dtPickerVM.loadPicker.observeAsState(initial = false)

    if (loadDatePickerDialog) {
        DatePickerSelectorScreen(datePickerSelectorVM = dtPickerVM)
    } else {
        Row() {
            val modifierRow = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(horizontal = 8.dp)
            when (dtPickerVM.boxes.value) {
                1 -> {//Sólo usamos caja desde
                    MyDatePickerBox(
                        dateValue = pickerBoxDesde,
                        hint = "Fecha Desde",
                        modifier = modifierRow.weight(1f),
                        onDateChanged = { dtPickerVM.dtOnChangeDesdeBox(it) },
                        onDateSelected = { dtPickerVM.openDatepicker(1) }
                    )
                }
                2 -> {//Usamos las dos cajas:
                    MyDatePickerBox(
                        dateValue = pickerBoxDesde,
                        hint = "Fecha Desde",
                        modifier = modifierRow.weight(1f),
                        onDateChanged = { dtPickerVM.dtOnChangeDesdeBox(it) },
                        onDateSelected = { dtPickerVM.openDatepicker(1) }
                    )
                    MyDatePickerBox(
                        dateValue = pickerBoxHasta,
                        hint = "Fecha Hasta",
                        modifier = modifierRow.weight(1f),
                        onDateChanged = { dtPickerVM.dtOnChangeHastaBox(it) },
                        onDateSelected = { dtPickerVM.openDatepicker(2) }
                    )
                }
            }
        }
    }

}


@Composable
fun MyDatePickerBox(
    dateValue: String,
    hint: String,
    modifier: Modifier,
    onDateChanged: (String) -> Unit,
    onDateSelected: () -> Unit
) {
    OutlinedTextField(
        value = dateValue,
        enabled = false,
        onValueChange = { onDateChanged(it) },//Cambia el valor
        modifier = modifier.clickable { onDateSelected() },//abre el datepicker
        maxLines = 1,
        singleLine = true,
        label = { Text(text = hint, color = Color.Red) }
    )
}




