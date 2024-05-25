package com.example.parchapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
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

        //imgBut1.setImageResource(R.drawable.event_musica)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainMusica2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var imgBut1 = findViewById<ImageButton>(R.id.imgBut1)
        imgBut1.setImageResource(R.drawable.event_musica)

        var imgBut2 = findViewById<ImageButton>(R.id.imgBut2)
        imgBut2.setImageResource(R.drawable.lugar_event1)

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
        imgBut1.setOnClickListener {

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