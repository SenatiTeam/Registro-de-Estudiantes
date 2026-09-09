package com.example.students

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.students.db.Config

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //invocamos al metodo
        cargarAlumnosDesdeDb()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun cargarAlumnosDesdeDb(){
        Thread{
            try {
                val config = Config(this)
                val lista = config.obtenerAlumnos()
                Log.d("PRUEBA_SQLite","Carga Completa recibiba MainActivity. Total: ${lista.size}")
            }catch (e: Exception){
                Log.e("PRUEBA_SQLite","Error desde MainActivity: ${e.message}")
            }
        }.start()
    }

}