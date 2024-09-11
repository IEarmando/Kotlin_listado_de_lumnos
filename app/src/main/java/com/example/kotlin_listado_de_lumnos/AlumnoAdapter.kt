package com.example.kotlin_listado_de_lumnos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter (private val context: Context, private val listAlumnos: List<Alumno>) : RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = listAlumnos[position]

        Glide.with(context).load(ItemsViewModel.foto).into(holder.imgFoto)

        holder.nombre.text = ItemsViewModel.nombre
        holder.numCuenta.text = ItemsViewModel.numCuenta
        holder.correo.text = ItemsViewModel.correo
    }

    override fun getItemCount(): Int {
        return listAlumnos.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.img_personas)
        val nombre: TextView = itemView.findViewById(R.id.tv_Nombre)
        val numCuenta: TextView = itemView.findViewById(R.id.tv_Num_Cuenta)
        val correo: TextView = itemView.findViewById(R.id.tv_Correo)
    }

}
