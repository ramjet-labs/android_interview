package io.mx51.androidinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import io.mx51.androidinterview.app_ui.LoadingScreen
import io.mx51.androidinterview.viewmodels.WeatherViewModel
import io.mx51.androidinterview.app_ui.WeatherDetailsScreen
import io.mx51.androidinterview.data.model.WeatherUnit
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeatherDetails()
        setContent {
            val weatherDetails = viewModel.weatherDetails.collectAsState().value
            val weatherPreference = viewModel.weatherPreference.collectAsState().value
            if (weatherDetails != null) {
                WeatherDetailsScreen(
                    locationName = weatherDetails.locationName,
                    temperature = weatherDetails.temperature,
                    windSpeed = weatherDetails.windSpeed,
                    description = weatherDetails.description,
                    metricUnit = weatherPreference.weatherUnit,
                    onRefreshClicked = {
                        viewModel.getWeatherDetails()
                    },
                    onMetricClicked = {
                        viewModel.setWeatherUnit(WeatherUnit.METRIC)
                    },
                    onImperialClicked = {
                        viewModel.setWeatherUnit(WeatherUnit.IMPERIAL)
                    }
                )
            } else {
                LoadingScreen()
            }
        }
    }
}
