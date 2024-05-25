package com.example.parchapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parchapp1.databinding.ActivityMainMusica2Binding

class MainMusica2 : AppCompatActivity() {
    lateinit var binding: ActivityMainMusica2Binding
    lateinit var  usuariosDBHelper: mySQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_musica2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainMusica2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var edtEvent1 = findViewById<EditText>(R.id.edtEvent1)
        edtEvent1.setOnClickListener {
            goEvent1()
        }
        var imgA2 = findViewById<ImageView>(R.id.imgA2)
        imgA2.setOnClickListener {
            goReverse2()
        }
        var btnParch1 = findViewById<Button>(R.id.btnParch1)
        btnParch1.setOnClickListener {
            goInscrito()
        }

    }
    private fun goEvent1(){

    }
    private fun goReverse2(){
        val  i = Intent(this, MainMenu::class.java)
        startActivity(i)

    }
    private fun goInscrito(){

    }
}