package com.android.rockscich5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.next_actv.*


class Next : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.next_actv)



        val nameUsername :TextView? = findViewById(R.id.text_pemain)
        val nameUsernameTwo: TextView? = findViewById(R.id.text_cpu)
        val i = intent
        val name: String? = i.getStringExtra("NAME_EXTRA")

        nameUsername!!.text = "$name VS Pemain"
        nameUsernameTwo!!.text = "$name VS CPU"
        val nameFix = name

        button_menu1.setOnClickListener {
            val c = Intent(this, PemainActivity::class.java)
            c.putExtra("NAME_EXTRA2", nameFix)
            startActivity(c)
            finish()
        }

        button_menu2.setOnClickListener {
            val d = Intent(this, CpuActivity::class.java)
            d.putExtra("NAME_EXTRA3", nameFix)
            startActivity(d)
            finish()
        }
        val fragment = supportFragmentManager
        val f = fragment.beginTransaction()
        val no = LpThreeFragNew()
        f.add(R.id.container, no)
        f.commit()

    }

    override fun onResume() {
        super.onResume()
        val i = intent
        val name: String? = i.getStringExtra("NAME_EXTRA")
        val nameFix = name

       val view = findViewById<View>(R.id.my_coordinatorLay)
        Snackbar.make(view, "SELAMAT DATANG $nameFix", Snackbar.LENGTH_LONG)
            .setAction(
                "UNDO"
            ) { Snackbar.make(view, "UNDO CLICKED!", Snackbar.LENGTH_SHORT).show() }.show()
    }


}


