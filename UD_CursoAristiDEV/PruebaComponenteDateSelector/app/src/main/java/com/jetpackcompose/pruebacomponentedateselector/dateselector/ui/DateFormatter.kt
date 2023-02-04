package com.jetpackcompose.pruebacomponentedateselector.dateselector.ui

import android.os.Build
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.util.*

class DateFormatter {
    companion object{
        private val SPANISH_NO_TIME_FORMAT: String = "dd/MM/yyyy"
        private val TAG="************* DATE FORMATTER ************"
        fun stringToLocalDate(date: String?): LocalDate? {
            val d: Date? = stringToDate(date)
            Log.d(TAG, "stringToLocalDate=> string=$date date=$d long=${d!!.time}")
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                d?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()
            } else null
        }
        fun localDateToString(date: LocalDate): String? {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val d = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
                Log.d(TAG, "localDateToString=> localdate=$date date=$d long=${d!!.time}")
                return formatDate(d, SPANISH_NO_TIME_FORMAT)
            }
            return ""
        }
        fun localDateToDate(localDate: LocalDate): Date? {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                var instant =
                    localDate.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant()
                Log.d(
                    TAG,
                    "localDateToString=> localdate=$localDate date=${Date.from(instant)} long=${
                        Date.from(instant)!!.time
                    }"
                )
                return Date.from(instant)
            }
            return null
        }
        fun stringToDate(date: String?): Date? {
            try {
                return SimpleDateFormat(SPANISH_NO_TIME_FORMAT).parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return null
        }
        fun formatDate(date: Date?, outPutFormat: String?): String? {
            return SimpleDateFormat(outPutFormat).format(date)
        }
    }
}