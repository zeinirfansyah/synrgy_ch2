package com.zen.synrgychallenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zen.synrgychallenge2.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            hitungTip()
        }
    }

    fun hitungTip() {
        val tulisanEditText = binding.etCostServie.text.toString()
        val cost = tulisanEditText.toDouble()

        val pilih = binding.rgPilihan.checkedRadioButtonId

        val persenTip = when (pilih) {
            R.id.radioButton1 -> 0.20
            R.id.radioButton2 -> 0.18
            else -> 0.15
        }

        var tip = persenTip * cost
        val roundUp = binding.switch1.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.text3.text = getString(R.string.tip_amount, formattedTip)


    }




}