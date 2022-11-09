package com.example.eyp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  authStateListener:FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

       setTheme(R.style.Theme_EYP1)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val btningresar : Button = findViewById(R.id.button)
        val txtemail : TextView = findViewById(R.id.editTextTextPersonName)
        val txtpass : TextView = findViewById(R.id.editTextTextPassword)
        val btnCrear_CuentaNueva : TextView = findViewById(R.id.btnCrearCuenta)

        firebaseAuth = Firebase.auth
        btningresar.setOnClickListener()
        {
            signIn(txtemail.text.toString(), txtpass.text.toString())
        }
        btnCrear_CuentaNueva.setOnClickListener()
        {
            val i = Intent(this, Button ::class.java)
            startActivity(i)
        }


    }
    private fun signIn(email: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                task->

            if (task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"Autenticacion Exitosa", Toast.LENGTH_SHORT).show()
                //Aqui vamos a ir a la segunda activity
                val i = Intent( this,Activity2::class.java )
                startActivity(i)
            }else
            {
                Toast.makeText(baseContext,"Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    }
