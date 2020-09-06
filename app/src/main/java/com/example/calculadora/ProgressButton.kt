package com.example.calculadora

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout

class ProgressButton {

    private var cardView: CardView? = null
    private var progressBar: ProgressBar? = null
    private var textView: TextView? = null
    private var layout: ConstraintLayout? = null

    var fade_in: Animation? = null

    constructor(ct: Context, view: View) {
        cardView = view.findViewById(R.id.cardView_buttom)
        layout = view.findViewById(R.id.constraint_layout)
        progressBar = view.findViewById(R.id.progressBar2)
        textView = view.findViewById(R.id.textView)
    }

    fun buttonActivated() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.text = "Espere"
    }

    fun buttonFinished(textButton: String) {
        layout!!.setBackgroundColor(cardView!!.resources.getColor(R.color.colorPrimary))
        progressBar!!.visibility = View.GONE
        textView!!.text = textButton
    }
}