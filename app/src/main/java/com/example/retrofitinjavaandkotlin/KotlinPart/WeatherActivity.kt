package com.example.retrofitinjavaandkotlin.KotlinPart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.retrofitinjavaandkotlin.R
import com.example.retrofitinjavaandkotlin.interfaces.WeatherServiceApi
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {
    private var weatherData: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherData=findViewById(R.id.weatherData)
        findViewById<View>(R.id.fetchWeatherData).setOnClickListener {
            getCurrentWeatherData()
        }

    }

    internal fun getCurrentWeatherData(){
        val retrofit=Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service=retrofit.create(WeatherServiceApi::class.java)
        val call=service.getCurrentWeatherData(lat ,lon, AppId)

        call.enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {

                if (response.code()==200){
                    val weatherResponse=response.body()!!
                    val stringBuilder="Country: " +
                            weatherResponse.sys!!.country + "\n" +
                            "Temperature: " + weatherResponse.main!!.temp + "\n" +
                            "Maximum Temperature: " + weatherResponse.main!!.temp_max + "\n" +
                            "Minimum Temperature: " + weatherResponse.main!!.temp_min + "\n" +
                            "Humidity: " + weatherResponse.main!!.humidity + "\n" +
                            "Pressure: " + weatherResponse.main!!.pressure

                    weatherData!!.text=stringBuilder
                 }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text=t.message
            }
        })
    }

    companion object{
        var BaseUrl:String="http://api.openweathermap.org/"
        var AppId=""
        var lat = "35"
        var lon = "139"
    }

}