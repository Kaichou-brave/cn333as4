package com.compose.unitconverter.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.compose.unitconverter.R

sealed class Screen(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
) {
    companion object {
        val screens = listOf(Temperature, Distances, Mass, Pressure)
    }

    private object Temperature : Screen(
        "temperature",
        R.string.temperature,
        R.drawable.outline_white_thermostat_24
    )

    private object Distances : Screen(
        "distance",
        R.string.distances,
        R.drawable.outline_white_square_foot_24
    )

    private object Mass : Screen(
        "mass",
        R.string.mass,
        R.drawable.outline_white_scale_24
    )

    private object Pressure : Screen(
        "pressure",
        R.string.pressure,
        R.drawable.outline_white_compress_24
    )
}

