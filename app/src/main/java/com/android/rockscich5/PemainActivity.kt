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

class PemainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)
        val textJudul1 = findViewById<TextView>(R.id.text_judul)
        val btnBatu = findViewById<ImageButton>(R.id.but_batu)
        val btnKertas = findViewById<ImageButton>(R.id.but_kertas)
        val btnGunting = findViewById<ImageButton>(R.id.but_gunting)
        val btnBatuCom = findViewById<ImageButton>(R.id.but_batu_com)
        val btnKertasCom = findViewById<ImageButton>(R.id.but_kertas_com)
        val btnGuntingCom = findViewById<ImageButton>(R.id.but_gunting_com)
         val btnReset = findViewById<ImageButton>(R.id.but_reset)
         val btnBack  = findViewById<ImageButton>(R.id.back)

        val i = intent
        val name2 = i.getStringExtra("NAME_EXTRA2")
        textJudul1!!.text = name2
        val imgMe: ImageView = findViewById(R.id.img_view_one)

        val tImg = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)

        btnReset.setOnClickListener {
            val myIntent = intent
            finish()
            startActivity(myIntent)
        }

        btnBack.setOnClickListener {
            val a = Intent(this, Next::class.java)
            a.putExtra("NAME_EXTRA",textJudul1.text)
            startActivity(a)
        }

        btnBatu.setOnClickListener(this)
        btnKertas.setOnClickListener(this)
        btnGunting.setOnClickListener(this)
        btnBatuCom.setOnClickListener(this)
        btnKertasCom.setOnClickListener(this)
        btnGuntingCom.setOnClickListener(this)
    }



    var user_input: Int = 0
    var user_input2: Int = 0
    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.but_batu -> {
                    user_input = 1
                    but_batu.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih batu", Toast.LENGTH_SHORT).show()
                }
                R.id.but_kertas -> {
                    user_input = 2
                    but_kertas.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih kertas", Toast.LENGTH_SHORT).show()
                }
                R.id.but_gunting -> {
                    user_input = 3
                    but_gunting.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Anda memilih gunting", Toast.LENGTH_SHORT).show()
                }
                R.id.but_batu_com ->{
                    user_input2 = 0
                    but_batu_com.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Pemain 2 memilih batu", Toast.LENGTH_SHORT).show()
                    cek(user_input,user_input2)
                }
                R.id.but_kertas_com ->{
                    user_input2 = 1
                    but_kertas_com.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Pemain 2 memilih kertas", Toast.LENGTH_SHORT).show()
                    cek(user_input,user_input2)
                }
                R.id.but_gunting_com ->{
                    user_input2 = 2
                    but_batu_com.setBackgroundResource(R.color.bg)
                    Toast.makeText(applicationContext, "Pemain 2 memilih gunting", Toast.LENGTH_SHORT).show()
                    cek(user_input,user_input2)
                }
            }
        }
    }



    //fungsi check
    fun cek(user_input : Int,user_input2 : Int) {
        if (user_input == 1 && user_input2 == 0) { //User choose Rock,Computer choose Rock
            hasil(2)
        } else if (user_input == 1 && user_input2 == 1) { //User choose Rock,Computer choose Paper
            hasil(0)
        } else if (user_input == 1 && user_input2 == 2) { //User choose Rock,Computer choose Scissors
            hasil(1)
        } else if (user_input == 2 && user_input2 == 0) { //User choose Paper,Computer choose Rock
            hasil(1)
        } else if (user_input == 2 && user_input2 == 1) { //User choose Paper,Computer choose Paper
            hasil(2)
        } else if (user_input == 2 &&user_input2 == 2) { //User choose Paper,Computer choose Scissors
            but_gunting_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && user_input2 == 0) { //User choose Scissors,Computer choose Rock
            but_batu_com.setBackgroundResource(R.color.bg)
            hasil(0)
        } else if (user_input == 3 && user_input2 == 1) { //User choose Scissors,Computer choose Paper
            hasil(1)
        } else if (user_input == 3 && user_input2 == 2) { //User choose Scissors,Computer choose Scissors
            hasil(2)
        }

    }

    fun hasil(hasil: Int) {

        if (hasil == 0) {
            val dialog = MyDialogFragment()

                dialog.show(supportFragmentManager,"custom")

        } else if (hasil == 1) {
            val dialog = MyDialogFragTwo()

                dialog.show(supportFragmentManager,"custom")

        } else {
            val dialog = MyDialogFragThree()

                dialog.show(supportFragmentManager,"custom")

        }
    }


}