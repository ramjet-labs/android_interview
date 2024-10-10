package io.mx51.androidinterview.data.model

enum class WeatherUnit {
    METRIC,
    IMPERIAL
}

data class WeatherDetails(
    val temperature: Double,
    val windSpeed: Double,
    val description: String,
    val locationName: String,
)

data class WeatherPreference(
    var weatherUnit: WeatherUnit = WeatherUnit.METRIC
)
