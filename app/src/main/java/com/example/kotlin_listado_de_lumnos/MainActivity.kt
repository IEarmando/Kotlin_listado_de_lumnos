package com.example.kotlin_listado_de_lumnos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFloating = findViewById<FloatingActionButton>(R.id.Floating_Button)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_personas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Alumno>()

        data.add(Alumno("Joel", "78965", "Joel@ucol.mx","https://loremflickr.com/320/240?random=5"))
        data.add(Alumno("Julio", "14585", "julio7@ucol.mx","https://loremflickr.com/320/240?random=6"))
        data.add(Alumno("Marcos", "78526", "Marcos@ucol.mx","https://loremflickr.com/320/240?random=8"))
        data.add(Alumno("Jersain", "10000", "Jersain@ucol.mx","https://loremflickr.com/320/240?random=2"))
        data.add(Alumno("Mario", "789655", "Mario@ucol.mx","https://loremflickr.com/320/240?random=1"))

        val adapter = AlumnoAdapter(this, data)
        recyclerView.adapter = adapter

        val parExtras = intent.extras
        val mensaje = parExtras?.getString("mensaje")
        val name = parExtras?.getString("name")
        val num_cuenta = parExtras?.getString("num_cuenta")
        val correo = parExtras?.getString("correo")
        val foto = parExtras?.getString("foto")

        if (mensaje == "nuevo alumno") {
            val insertIndex: Int = data.count()
            data.add(insertIndex, Alumno(name.toString(),
                num_cuenta.toString(),
                correo.toString(),
                foto.toString()))
            adapter.notifyItemInserted(insertIndex)
        }

        buttonFloating.setOnClickListener {
            val intent1 = Intent(this, MainActivity2::class.java)
            startActivity(intent1)
            finish()
        }
    }
}
