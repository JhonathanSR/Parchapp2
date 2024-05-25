package com.example.parchapp1

import android.content.Intent
import android.os.Bundle
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
    //lateinit var edTNombre: EditText
    //lateinit var edTPass2: EditText
    // lateinit var btn_Registro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
                        ActivityMainRegistroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuariosDBHelper = mySQLiteHelper(this)
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
            }
            /*val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            //finish()*/
            var imgR1 = findViewById<ImageView>(R.id.imgR1)
            imgR1.setOnClickListener {
                goReverse()
            }

        }
    }

    private fun goReverse() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}



