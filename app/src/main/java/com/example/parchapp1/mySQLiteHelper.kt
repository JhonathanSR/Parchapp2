package com.example.parchapp1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class mySQLiteHelper (context: Context): SQLiteOpenHelper(
    context, "usuarios.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "nombre TEXT," + "contrasena TEXT)"
        db!!.execSQL(ordenCreacion)

    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS usuarios"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }
    fun anadirdato(nombre: String, contrasena: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("nombre", nombre)
            put("contrasena", contrasena)
        }

        val result = db.insert("usuarios", null, contentValues)
        Log.d("mySQLiteHelper", "Insert result: $result")
        db.close()
        return result != -1L
    }

    fun obtenerDatos(nombre: String, contrasena: String): Boolean{
        val db = this.readableDatabase
        val query = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?"
        val cursor =db.rawQuery(query, arrayOf(nombre, contrasena))
        val count = cursor.count
        cursor.close()
        return count > 0

    }
    /*fun agregarDato(nombre: String, contrasena: String){

    }*/
     /*fun iniciarDatabase(){
         val db = this.writableDatabase
         db.execSQL("INSERT INTO TABLE usuarios(nombre, contraseña)VALUES ('testuser', 'testpass')")
     }*/



}