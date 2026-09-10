package com.example.students.iu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.model.Alumno

/*Adpator de RecyclerView*/
class AlumnoAdapter(private var alumnos: List<Alumno>) :
    RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): AlumnoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumno, parent, false)
        return AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder,position: Int) {
        val alumno = alumnos[position]
        holder.tvNombreCompleto.text = "${alumno.nombre} ${alumno.apellido}"
        holder.tcCodigo.text = "${alumno.codigo}"
    }

    override fun getItemCount(): Int = alumnos.size

    fun updateData(newAlumnos: List<Alumno>){
        this.alumnos = newAlumnos
        notifyDataSetChanged()
    }

    /*Paso 1: Clase ViewHolder*/
    class AlumnoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvNombreCompleto: TextView = view.findViewById<TextView>(R.id.tvNombreCompleto)
        val tcCodigo: TextView = view.findViewById<TextView>(R.id.tvCodigo)
    }

}