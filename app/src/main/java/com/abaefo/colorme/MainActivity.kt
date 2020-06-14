package com.abaefo.colorme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abaefo.colorme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setListeners()
    }

    fun setListeners() {
        var clickBox: List<View>

        binding.apply {
            clickBox = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, constraint, redButton, greenButton, yellowButton)
        }

        for (item in clickBox) {
            item.setOnClickListener { makeColored((it)) }
        }
    }

    fun makeColored(view: View) {


        binding.apply {
            when (view) {
                // Boxes using Color class colors for background
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)

                // Boxes using Android color resources for background
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_blue_light)

                redButton -> boxThreeText.setBackgroundResource(android.R.color.holo_purple)
                yellowButton -> boxFourText.setBackgroundResource(android.R.color.holo_orange_light)
                greenButton -> boxFiveText.setBackgroundResource(android.R.color.holo_blue_dark)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }


    }
}