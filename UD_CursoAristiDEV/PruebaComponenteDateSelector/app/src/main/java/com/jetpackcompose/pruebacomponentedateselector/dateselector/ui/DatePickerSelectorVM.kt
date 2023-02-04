package com.jetpackcompose.pruebacomponentedateselector.dateselector.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DateFormatter.Companion.localDateToDate
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DateFormatter.Companion.localDateToString
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DateFormatter.Companion.stringToDate
import com.jetpackcompose.pruebacomponentedateselector.dateselector.ui.DateFormatter.Companion.stringToLocalDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.util.*


class DatePickerSelectorVM(boxes: Int) : ViewModel() {
    val TAG = "DatePickerSelectorVM"

    // region Número de cajas de la que consta el selector
    private val _boxes = MutableLiveData(boxes)
    val boxes = _boxes
    // endregion
    // region Caja que ha abierto el datepicker
    private val _boxThatOpenedDT = MutableLiveData(1)
    val boxThatOpenedDT = _boxThatOpenedDT
    // endregion
    // region Campos para los textfields de las cajas del DatePickerSelectorScreen
    private val _dtPickerBoxDesde = MutableLiveData("")
    val dtPickerBoxDesde = _dtPickerBoxDesde
    fun dtOnChangeDesdeBox(changed: String) {_dtPickerBoxDesde.value = changed }
    private val _dtPickerBoxHasta = MutableLiveData("")
    val dtPickerBoxHasta = _dtPickerBoxHasta
    fun dtOnChangeHastaBox(changed: String) { _dtPickerBoxHasta.value = changed }
    // endregion
    //region Campos LastDateSaved de control
    @RequiresApi(Build.VERSION_CODES.O)
    private val _lastFromSaved =MutableLiveData(getLastSavedDate(_dtPickerBoxDesde.value!!))
    @RequiresApi(Build.VERSION_CODES.O)
    private val _lastToSaved =MutableLiveData(getLastSavedDate(_dtPickerBoxHasta.value!!))
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getLastSavedDate(stringDate: String):LocalDate {
        var dateT = LocalDate.now()
        if (stringDate != null && stringDate.isNotEmpty()) {
            dateT = stringToLocalDate(stringDate)
        }
        return dateT
    }
    //endregion
    //region Campo para saber si se tiene que cargar el datepicker Dialog y sus funciones de apertura/cierre
    private val _loadPicker = MutableLiveData(false)
    val loadPicker = _loadPicker
    @RequiresApi(Build.VERSION_CODES.O)
    fun openDatepicker(boxClicked: Int) {
        if(boxClicked==2 && _dtPickerBoxDesde.value!!.isEmpty()){
            Log.d(TAG, " click en segunda caja sin primera fecha")
        }else{
            _loadPicker.value = true //Mostramos el dialog
            _boxThatOpenedDT.value = boxClicked //Seteamos la caja que lo ha abierto
            //Seteamos el valor por defecto del date, con el último valor guardado de la caja correspondiente:
            _defaultDate.value= if(boxThatOpenedDT.value == 2) _lastToSaved.value else _lastFromSaved.value
            //Seteamos el valor por defecto mínimo del calendario:
            if (boxThatOpenedDT.value == 2) {
                _minDate.value=stringToDate(_dtPickerBoxDesde.value)?.time ?: 0L
            } else {
                _minDate.value=0L
            }
            Log.d(TAG, " opened by $boxClicked")
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun closeDatePicker(saveDate: Boolean) { //SaveDate= true sólo cuando da a OK.
        Log.d(TAG, " closing: $saveDate")
        if (saveDate) {
            when (boxes.value) {
                1 -> {
                    //Pasamos a string el valor del defaultValue
                    if (_defaultDate.value != null) {
                        //Cambiamos la variable de control de la caja de texto de DESDE
                        dtOnChangeDesdeBox(localDateToString(_defaultDate.value!!)!!)
                        _lastFromSaved.value=_defaultDate.value
                    }
                } //Tenemos sólo una caja
                2 -> {//Tenemos dos cajas
                    when (_boxThatOpenedDT.value) {//Se ha abierto la primera
                        1 -> {
                            //Pasamos a string el valor del defaultValue
                            if (_defaultDate.value != null) {
                                //Cambiamos la variable de control de la caja de texto de DESDE
                                dtOnChangeDesdeBox(localDateToString(_defaultDate.value!!)!!)
                                _lastFromSaved.value=_defaultDate.value
                            }
                        }
                        2 -> {//Se ha abierto la segunda
                            if (_defaultDate.value != null) {
                                //Cambiamos la variable de control de la caja de texto de DESDE
                                dtOnChangeHastaBox(localDateToString(_defaultDate.value!!)!!)
                                _lastToSaved.value=_defaultDate.value
                            }
                        }
                    }
                }
            }
        }
        _loadPicker.value = false
    }
    // endregion
    //region Datos del Dialog DatePicker
    fun getTitleDialog(): String {
        return if (boxThatOpenedDT.value == 1) {
            "Elige fecha desde"
        } else {
            "Elige fecha hasta"
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private val _defaultDate = MutableLiveData(
        if (boxThatOpenedDT.value == 2) {
            stringToLocalDate(_dtPickerBoxDesde.value) ?: LocalDate.now()
        } else {
            LocalDate.now()
        }
    )
    @RequiresApi(Build.VERSION_CODES.O)
    val defaultDate = _defaultDate

    @RequiresApi(Build.VERSION_CODES.O)
    fun changeDefaultDate(changed: LocalDate) {
        _defaultDate.value = changed
        Log.d(TAG, " changeDefaultDate: $changed")
    }
//region Min/Max
    //Max Date:
    private val _maxDate = MutableLiveData(
        Date().time//En teoría los expedientes salen al día, con lo que no se van a poden consultar expedientes de mañana:
    )
    val maxDate = _maxDate

    //MinDate:
    //Si tenemos fecha desde, el mín es fecha desde
    private val _minDate = MutableLiveData(
        if (boxThatOpenedDT.value == 2) {
            stringToDate(_dtPickerBoxDesde.value)?.time ?: 0L
        } else {
            0L
        }
    )
    val minDate: LiveData<Long>? = _minDate
//endregion Min/Max
    //endregion

}