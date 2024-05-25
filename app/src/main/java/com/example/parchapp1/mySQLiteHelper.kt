package com.example.parchapp1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySQLiteHelper (context: Context): SQLiteOpenHelper(
    context, "usuarios.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE usuarios" +
                ("id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nombre TEXT, contraseña TEXT ")
        db!!.execSQL(ordenCreacion)

    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS usuarios"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }
    fun anadirdato(nombre: String, contraseña: String) {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("contraseña", contraseña)
        //datos.put("email", email)

        val db = this.writableDatabase
        db.insert("usuarios", null, datos)
        db.close()
    }

    fun obtenerDatos(nombre: String, contraseña: String): Boolean{
        val db = this.readableDatabase
        val query = "SELECT * FROM  TABLE usuarios where nombre = ? &&  contraseña = ?"
        val cursor =db.rawQuery(query, arrayOf(nombre, contraseña))
        val count = cursor.count
        cursor.close()
        return count > 0

    }
    fun agregarDato(nombre: String, contraseña: String){

    }
     /*fun iniciarDatabase(){
         val db = this.writableDatabase
         db.execSQL("INSERT INTO TABLE usuarios(nombre, contraseña)VALUES ('testuser', 'testpass')")
     }*/



}