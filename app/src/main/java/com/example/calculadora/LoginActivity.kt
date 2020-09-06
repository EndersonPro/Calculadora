package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var view: View;

    private var email: String = "admin@unimagdalena.edu.co"
    private var password: String = "admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        // to hide appbar :)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        view = findViewById(R.id.myCustomProgressbar)

        view.setOnClickListener { v -> login(v)}

    }

    private fun login (view: View) {
        // get data to input in view
        val currentEmail: String = txtEmail.text.trim().toString()
        val currentPassword: String = txtPassword.text.trim().toString()

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            val progressButton: ProgressButton = ProgressButton(this@LoginActivity, view)
            val handler: Handler = Handler();
            progressButton.buttonActivated();
            handler.postDelayed(Runnable {
                if (currentEmail == email && currentPassword == password) {
                    progressButton.buttonFinished("Ingresando...")
                    val intent = Intent(this, MathActivity::class.java)
                    startActivity(intent)
                    finish();
                } else {
                    val myToast = Toast.makeText(applicationContext,"Correo o contraseña incorrectos",Toast.LENGTH_SHORT)
                    myToast.show()
                    progressButton.buttonFinished(resources.getString(R.string.login))
                }
            }, 3000)

        } else {

        }
    }
}