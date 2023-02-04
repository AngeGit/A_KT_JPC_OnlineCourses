package com.jetpackcompose.pruebacomponentedateselector.dateselector.ui

import android.os.Build
import android.util.Log
import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DateFormatter.Companion.localDateToDate
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickerSelectorScreen(datePickerSelectorVM: DatePickerSelectorVM) {
    //Fecha por defecto que va a aparecer en el calendario:
    val selDate: LocalDate by datePickerSelectorVM.defaultDate.observeAsState(initial = LocalDate.now())
    val minDate: Long by datePickerSelectorVM.minDate!!.observeAsState(Date().time)

    Dialog(
        onDismissRequest = { datePickerSelectorVM.closeDatePicker(false) },
        properties = DialogProperties()
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            PickerHeader(datePickerSelectorVM.getTitleDialog(), selDate)


            CustomCalendarView(
                if(selDate.compareTo(LocalDate.now())==0)  0L else localDateToDate(selDate)!!.time,
                minDate,
                datePickerSelectorVM.maxDate.value!!,
                onDateSelected = {
                    datePickerSelectorVM.changeDefaultDate(it)
                }
            )
            PickerButtons(
                Modifier.align(Alignment.End),
                onDismissRequest = { datePickerSelectorVM.closeDatePicker(false) },
                onOkClicked = { datePickerSelectorVM.closeDatePicker(true) }
            )
        }
    }
}


@Composable
fun PickerButtons(modifier: Modifier,onDismissRequest: () -> Unit, onOkClicked: () -> Unit) {
    Row(
        modifier = modifier
            .padding(bottom = 16.dp, end = 16.dp)
    ) {
        TextButton(onClick = onDismissRequest) {
            Text(
                text = "Cancelar",
                style = MaterialTheme.typography.button,
                color = Color.Red,
            )
        }
        TextButton( onClick =  onOkClicked) {
            Text(
                text = "OK",
                style = MaterialTheme.typography.button,
                color = Color.Red,
            )
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickerHeader(title: String, selDate: LocalDate) {
    Column(
        Modifier
            .defaultMinSize(minHeight = 72.dp)
            .fillMaxWidth()
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = title.uppercase(Locale("es", "ES")),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onPrimary
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = selDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.End
        )
    }
    Spacer(modifier = Modifier.size(8.dp))
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomCalendarView(defaultDate: Long, minDate:Long,maxDate:Long, onDateSelected: (LocalDate) -> Unit) {
// Adds view to Compose
    AndroidView(
        modifier = Modifier.wrapContentSize(),
        factory = { context ->
            //Cambiamos la configuración de Locale para que el dispositivo coja el calendario en ES:
            var locale: Locale = Locale("es", "ES")
            Locale.setDefault(Locale.Category.FORMAT, locale)
            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
            context.createConfigurationContext(configuration)

            //y le pasamos ese contexto a la vista
            CalendarView(context

            )//ContextThemeWrapper(context, R.style.CalenderViewCustom)

        },
        update = { view ->
            if(minDate!=0L){
                view.minDate= minDate
            }
            if(maxDate!=0L){
                view.maxDate= maxDate
            }
            if(defaultDate!=0L){
                view.date=defaultDate
            }

              //

            Log.d("DatePickerSelectorVM","$defaultDate")

            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                onDateSelected(
                    LocalDate
                        .now()
                        .withMonth(month + 1)
                        .withYear(year)
                        .withDayOfMonth(dayOfMonth)
                )
            }
        }
    )

}


