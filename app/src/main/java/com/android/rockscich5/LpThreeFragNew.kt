package com.android.rockscich5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class LpThreeFragNew : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_lp_three_frag_new, container, false)
        val edt = v.findViewById<View>(R.id.edit_text) as EditText
        val next = v.findViewById<View>(R.id.button_next) as ImageButton

        next.setOnClickListener {
            val i = Intent(
                activity!!.baseContext,
                Next::class.java
            )

            i.putExtra("NAME_EXTRA", edt.text.toString())
            activity?.startActivity(i)
        }
        return v
    }

}