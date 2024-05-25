package com.example.parchapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parchapp1.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {
    lateinit var  binding: ActivityMainMenuBinding
    lateinit var  usuariosDBHelper: mySQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainMenuBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnMusica = findViewById<Button>(R.id.btnMusica)
        btnMusica.setOnClickListener {
            goMusic2()
        }
        var btnCultura = findViewById<Button>(R.id.btnCultura)
        btnCultura.setOnClickListener {
            goCultura()
        }
        var btnRestau = findViewById<Button>(R.id.btnRestau)
        btnRestau.setOnClickListener {
            goResta()
        }
        var btnDeportes = findViewById<Button>(R.id.btnDeportes)
        btnDeportes.setOnClickListener {
            goDeport()
        }
        var img_Exit = findViewById<ImageView>(R.id.img_Exit)
        img_Exit.setOnClickListener {
            goSalida()
        }
    }
    private fun goMusic2(){
        val i = Intent(this, MainMusica2::class.java)
        startActivity(i)
    }
    private fun goCultura(){
        val i = Intent(this, MainCultura::class.java)
        startActivity(i)
    }
    private fun goResta(){
        val i = Intent(this, MainRestaurantes::class.java)
        startActivity(i)
    }
    private fun goDeport(){
        val i = Intent(this, MainDeportes::class.java)
        startActivity(i)
    }
    private fun goSalida(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}