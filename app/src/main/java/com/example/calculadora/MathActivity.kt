package com.example.calculadora

import android.content.res.Resources
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MathActivity : AppCompatActivity() {

    // variables para la suma
    private lateinit var suma_n1: EditText
    private lateinit var suma_n2: EditText
    private lateinit var suma_result: TextView

    // variables para la resta
    private lateinit var subtraction_n1: EditText
    private lateinit var subtraction_n2: EditText
    private lateinit var subtraction_result: TextView

    // variables para MCM, MCD y mayor
    private lateinit var m_n1: EditText
    private lateinit var m_n2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)
        // Para la suma
        suma_n1 = findViewById(R.id.sum_n1)
        suma_n2 = findViewById(R.id.sum_n2)
        suma_result = findViewById(R.id.result_sum)

        // Para la resta
        subtraction_n1 = findViewById(R.id.subtraction_n1)
        subtraction_n2 = findViewById(R.id.subtraction_n2)
        subtraction_result = findViewById(R.id.result_subtraction)

        // others
        m_n1 = findViewById(R.id.m_n1)
        m_n2 = findViewById(R.id.m_n2)
        result = findViewById(R.id.result)
    }

    fun sum(view: View) {
        // handle sum
        var currentN1: Int = suma_n1.text.trim().toString().toInt()
        var currentN2: Int = suma_n2.text.trim().toString().toInt()
        var result: Int = currentN1 + currentN2
        suma_result.setText(result.toString())
    }

    fun subtraction (view: View) {
        var currentN1: Int = subtraction_n1.text.trim().toString().toInt()
        var currentN2: Int = subtraction_n2.text.trim().toString().toInt()
        var result: Int = currentN1 - currentN2
        subtraction_result.setText(result.toString())
    }

    // fun addNumber (view: View) {
    //    if (currentid <= 6) {
    //        val ll: LinearLayout = findViewById(R.id.numbers)
    //        val et: EditText = EditText(this);
    //        // et.layoutParams = (ViewGroup.LayoutParams(60,40))
    //        et.width = 30.toPx()
    //        et.height = 40.toPx()
    //        et.background = this.getDrawable(R.drawable.input_number)
    //        et.inputType = InputType.TYPE_CLASS_NUMBER
    //        // et.id = "m_n$currentid.toString()"
    //        ll.addView(et)
    //        currentid++
    //    } else {
    //        val myToast = Toast.makeText(applicationContext,"Cantidad de numeros maximo alcanzado",Toast.LENGTH_SHORT)
    //        myToast.show()
    //    }
    // }

    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

    fun MCM (view: View) {
        var currentN1: Int = m_n1.text.trim().toString().toInt()
        var currentN2: Int = m_n2.text.trim().toString().toInt()
        var r: Int = currentN1 * currentN2 / MCDs(currentN1, currentN2)
        result.setText(r.toString())
    }

    fun MCD (view: View) {
        var currentN1: Int = m_n1.text.trim().toString().toInt()
        var currentN2: Int = m_n2.text.trim().toString().toInt()
        var temp: Int;
        while (currentN2 != 0) {
            temp = currentN2
            currentN2 = currentN1 % currentN2
            currentN1 = temp
        }
        result.setText(currentN1.toString())
    }

    fun MCDs (n1: Int, n2: Int): Int {
        var temp: Int;
        var temp2: Int = n2
        var temp3: Int = n1
        while (temp2 != 0) {
            temp = temp2
            temp2 = temp3 % temp2
            temp3 = temp
        }
        return temp3
    }

    fun mayor (view: View) {
        var currentN1: Int = m_n1.text.trim().toString().toInt()
        var currentN2: Int = m_n2.text.trim().toString().toInt()
        var mayor: Int = currentN2;
        if (currentN1 > currentN2) mayor = currentN1;
        result.setText(mayor.toString())
    }

    // fun MCM (view: View) {
    // val ll: LinearLayout = findViewById(R.id.numbers)
    //    val list: MutableList<Int> = ArrayList<Int>()
    //    val childCountll: Int = ll.childCount;
    // for (x in 0..childCountll) {
    //        var v = ll.getChildAt(x)
    //        if (v is EditText) {
    //            list.add(v.text.trim().toString().toInt())
    //        }
    //    }
    //    result.setText(list[0].toString())
    // }
}