package com.compose.unitconverter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.compose.unitconverter.R
import java.lang.NumberFormatException

class MassViewModel: ViewModel() {
    private val _unit: MutableLiveData<Int> = MutableLiveData(R.string.kilometer)

    val unit: LiveData<Int>
        get() = _unit

    fun setUnit(value: Int) {
        _unit.value = value
    }

    private val _mass: MutableLiveData<String> = MutableLiveData("")

    val mass: LiveData<String>
        get() = _mass

    fun getDistanceAsFloat(): Float = (_mass.value?: "")?.let { value ->
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            Float.NaN
        }
    }


    fun setDistance(value: String) {
        _mass.value = value
    }

    fun convert() =
        getDistanceAsFloat().let { value ->
            if (!value.isNaN())
                if (_unit.value == R.string.kilometer)
                    value * 2.2F
                else
                    value / 2.2F
            else
                Float.NaN
        }
}