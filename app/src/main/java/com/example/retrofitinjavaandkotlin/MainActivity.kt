package com.example.retrofitinjavaandkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitinjavaandkotlin.JavaPart.AvengerActivity
import com.example.retrofitinjavaandkotlin.KotlinPart.WeatherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kotlin.setOnClickListener{
            val intent=Intent(this,WeatherActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        java.setOnClickListener {
            val intent=Intent(this,AvengerActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }
}
