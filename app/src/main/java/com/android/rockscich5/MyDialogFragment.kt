package com.android.rockscich5

import android.annotation.SuppressLint
import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import kotlinx.android.synthetic.main.fragment_dialog.*
import kotlinx.android.synthetic.main.fragment_dialog.view.*

class MyDialogFragment : DialogFragment(){

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val rootView : View = inflater.inflate(R.layout.fragment_dialog, container, false)

        rootView.button_play_again.setOnClickListener {
            val intent = Intent(activity, PemainActivity::class.java)
            startActivity(intent)
        }

        rootView.button_back_menu.setOnClickListener {
            val intent = Intent(activity, Next::class.java)
            startActivity(intent)
        }
        return rootView

    }
}