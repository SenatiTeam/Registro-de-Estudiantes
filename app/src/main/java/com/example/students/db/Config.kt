package com.example.students.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQuery
import android.util.Log
import com.example.students.model.Alumno
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.sql.SQLXML

/*Paso 1: Conexión y Lectura de Datos de la Base de Datos SQLite*/

class Config(private val context: Context) {
    private val dbName = "alumns.sql"

    /*Extraer la lista de alumnos desde SQLite*/
    fun obtenerAlumnos(): List<Alumno> {
        val listaAlumnos = mutableListOf<Alumno>()
        val dbFile = File(context.filesDir, dbName)
        /*Copia de seguridad / inicializacion de los archivos de la DB desde assets*/
        try {
            val inputStream: InputStream = context.assets.open(dbName)
            val outputStream: OutputStream = FileOutputStream(dbFile)
            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0){
                outputStream.write(buffer, 0, length)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
        }catch (e: Exception){
            Log.e("PRUEBA_SQLite", "Error al copiar DB: ${e.message}")
        }
        /*1.2 Apertura de la conexion SQLite y ejecucion de la consutla*/
        try {
            val db = SQLiteDatabase.openDatabase(
                dbFile.absolutePath, null, SQLiteDatabase.OPEN_READONLY
            )
            val cursor = db.rawQuery("SELECT codigo, nombre, apellido, telefono FROM alumns", null)
            Log.d("PRUEBA_SQLite", "Datos Encontrados de alumnos: ${cursor.count}")
        }
    }

}