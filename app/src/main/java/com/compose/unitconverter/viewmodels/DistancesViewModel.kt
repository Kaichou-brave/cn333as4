package com.compose.unitconverter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.compose.unitconverter.R
import java.lang.NumberFormatException

class DistancesViewModel : ViewModel() {
    private val _unit: MutableLiveData<Int> = MutableLiveData(R.string.meter)

    val unit: LiveData<Int>
        get() = _unit

    fun setUnit(value: Int) {
        _unit.value = value
    }

    private val _distance: MutableLiveData<String> = MutableLiveData("")

    val distance: LiveData<String>
        get() = _distance

    fun getDistanceAsFloat(): Float = (_distance.value?: "")?.let { value ->
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            Float.NaN
        }
    }


    fun setDistance(value: String) {
        _distance.value = value
    }

    fun convert() =
        getDistanceAsFloat().let { value ->
            if (!value.isNaN())
                if (_unit.value == R.string.meter)
                    value * 0.00062137F
                else
                    value / 0.00062137F
            else
                Float.NaN
        }


}
