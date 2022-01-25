package io.mx51.androidinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import io.mx51.androidinterview.app_ui.LoadingScreen
import io.mx51.androidinterview.viewmodels.WeatherViewModel
import io.mx51.androidinterview.app_ui.WeatherDetailsScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeatherDetails()
        setContent {
            val weatherDetails = viewModel.weatherDetails.collectAsState().value
            if (weatherDetails != null) {
                WeatherDetailsScreen(
                    locationName = weatherDetails.locationName,
                    temperature = weatherDetails.temperature,
                    windSpeed = weatherDetails.windSpeed,
                    description = weatherDetails.description
                ) {
                    viewModel.getWeatherDetails()
                }
            } else {
                LoadingScreen()
            }
        }
    }
}