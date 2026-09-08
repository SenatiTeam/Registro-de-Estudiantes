package com.example.students.db

import android.content.Context
import com.example.students.model.Alumno
import java.io.File
import java.io.InputStream

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
        }
    }

}