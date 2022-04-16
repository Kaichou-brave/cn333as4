package com.compose.unitconverter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.compose.unitconverter.R
import java.lang.NumberFormatException

class PressureViewModel: ViewModel() {
    private val _unit: MutableLiveData<Int> = MutableLiveData(R.string.bar)

    val unit: LiveData<Int>
        get() = _unit

    fun setUnit(value: Int) {
        _unit.value = value
    }

    private val _pressure: MutableLiveData<String> = MutableLiveData("")

    val pressure: LiveData<String>
        get() = _pressure

    fun getPressureAsFloat(): Float = (_pressure.value?: "")?.let { value ->
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            Float.NaN
        }
    }


    fun setPressure(value: String) {
        _pressure.value = value
    }

    fun convert() =
        getPressureAsFloat().let { value ->
            if (!value.isNaN())
                if (_unit.value == R.string.bar)
                    value * 14.503773773F
                else
                    value / 14.503773773F
            else
                Float.NaN
        }
}