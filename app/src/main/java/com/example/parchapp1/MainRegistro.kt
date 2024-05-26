package com.example.parchapp1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parchapp1.databinding.ActivityMainRegistroBinding

class MainRegistro : AppCompatActivity() {
    lateinit var binding: ActivityMainRegistroBinding
    lateinit var usuariosDBHelper: mySQLiteHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usuariosDBHelper = mySQLiteHelper(this)
        var imgR1 = findViewById<ImageView>(R.id.imgR1)
        imgR1.setOnClickListener {
            goReverse()
        }
        val btnRegistro: Button = findViewById(R.id.btnRegistro)
        btnRegistro.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val nombre = findViewById<EditText>(R.id.edTNombre).text.toString()
        val contrasena = findViewById<EditText>(R.id.edTPass2).text.toString()
        //Toast.makeText(this, "Usuario Registrado",
            //Toast.LENGTH_SHORT).show()

        Log.d("RegisterUser", "Nombre: $nombre, Contrasena: $contrasena")

        if (nombre.isNotEmpty() && contrasena.isNotEmpty()) {
            val usuariosDBHelper = mySQLiteHelper(this)
            val resultado = usuariosDBHelper.anadirdato(nombre, contrasena)

            Log.d("RegisterUser", "User registration resultado: $resultado")

            if (resultado) {
                Toast.makeText(
                    this, "Usuario Registrado",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Usuario y contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                this, "Complete todos los campos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun goReverse() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}

        /*usuariosDBHelper = mySQLiteHelper(this)
        binding.btnRegistro.setOnClickListener {
            if (binding.edTNombre.text.isNotBlank() &&
                binding.edTPass2.text.isNotBlank()
            ) {
                usuariosDBHelper.anadirdato(
                    binding.edTNombre.text.toString(),
                    binding.edTPass2.text.toString()
                )
                binding.edTNombre.text.clear()
                binding.edTPass2.text.clear()
                Toast.makeText(
                    this, "Registro Completado",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this, "Usuario y contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }*/
            /*val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            //finish()*/









