package com.android.rockscich5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_pemain.*

class CpuActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpu)
        val text_judul1:TextView? = findViewById<TextView>(R.id.text_judul)
        val btn_batu = findViewById<ImageButton>(R.id.but_batu)
        val btn_kertas = findViewById<ImageButton>(R.id.but_kertas)
        val btn_gunting = findViewById<ImageButton>(R.id.but_gunting)
       val btn_reset = findViewById<ImageButton>(R.id.but_reset)
       val btn_back : ImageButton = findViewById<ImageButton>(R.id.back)

        val z: Intent = intent
        val name2: String? = z.getStringExtra("NAME_EXTRA3")
        text_judul1!!.text = name2
        val imgMe: ImageView = findViewById(R.id.img_view_one)

        val tImg = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)

        btn_reset.setOnClickListener {
            val myIntent = intent
            finish()
            startActivity(myIntent)
        }

        btn_back.setOnClickListener {
            val j = Intent(this, Next::class.java)
            j.putExtra("NAME_EXTRA",text_judul1.text)
            startActivity(j)
        }

        btn_batu.setOnClickListener(this)
        btn_kertas.setOnClickListener(this)
        btn_gunting.setOnClickListener(this)
    }


    var user_input: Int = 0
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.but_batu -> {
                    user_input = 1
                    but_batu.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih batu", Toast.LENGTH_SHORT).show()
                    randomLawan()
                }
                R.id.but_kertas -> {
                    user_input = 2
                    but_kertas.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih kertas", Toast.LENGTH_SHORT).show()
                    randomLawan()
                }
                R.id.but_gunting -> {
                    user_input = 3
                    but_gunting.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih gunting", Toast.LENGTH_SHORT).show()
                    randomLawan()
                }
            }
        }
    }


    private fun randomLawan() {
        val ran: Double = (Math.random() * 3)
        val ran01 = ran.toInt()
        cek(ran01)
    }

    //fungsi check
    fun cek(ran: Int) {
        if (user_input == 1 && ran == 0) { //User choose Rock,Computer choose Rock
            but_batu_com.setBackgroundResource(R.color.bg)
            Toast.makeText(applicationContext, "CPU memilih Batu", Toast.LENGTH_SHORT).show()
            hasil(2)

        } else if (user_input == 1 && ran == 1) { //User choose Rock,Computer choose Paper
            but_kertas_com.setBackgroundResource(R.color.bg)
            Toast.makeText(applicationContext, "CPU memilih kertas", Toast.LENGTH_SHORT).show()
            hasil(0)
        } else if (user_input == 1 && ran == 2) { //User choose Rock,Computer choose Scissors
            but_gunting_com.setBackgroundResource(R.color.bg)
            Toast.makeText(applicationContext, "CPU memilih gunting", Toast.LENGTH_SHORT).show()
            hasil(1)
        } else if (user_input == 2 && ran == 0) { //User choose Paper,Computer choose Rock
            Toast.makeText(applicationContext, "CPU memilih batu", Toast.LENGTH_SHORT).show()
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(1)
        } else if (user_input == 2 && ran == 1) { //User choose Paper,Computer choose Paper
            Toast.makeText(applicationContext, "CPU memilih kertas", Toast.LENGTH_SHORT).show()
            but_kertas_com.setBackgroundResource(R.color.bg)
            hasil(2)
        } else if (user_input == 2 && ran == 2) { //User choose Paper,Computer choose Scissors
            Toast.makeText(applicationContext, "CPU memilih gunting", Toast.LENGTH_SHORT).show()
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && ran == 0) { //User choose Scissors,Computer choose Rock
            Toast.makeText(applicationContext, "CPU memilih batu", Toast.LENGTH_SHORT).show()
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && ran == 1) { //User choose Scissors,Computer choose Paper
            Toast.makeText(applicationContext, "CPU memilih kertas", Toast.LENGTH_SHORT).show()
            but_kertas_com.setBackgroundResource(R.color.bg)
            hasil(1)
        } else if (user_input == 3 && ran == 2) { //User choose Scissors,Computer choose Scissors
            Toast.makeText(applicationContext, "CPU memilih gunting", Toast.LENGTH_SHORT).show()
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(2)
        }
    }

    fun hasil(hasil: Int) {
        if (hasil == 0) {
            val dialog = CpuDialogFrag()

                dialog.show(supportFragmentManager,"custom")

        } else if (hasil == 1) {
            val dialog = CpuDialogFragTwo()

                dialog.show(supportFragmentManager,"custom")

        } else {
            val dialog =  CpuDialogFragThree()

                dialog.show(supportFragmentManager,"custom")

        }
    }

}