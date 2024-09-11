package com.example.kotlin_listado_de_lumnos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button_add = findViewById<Button>(R.id.button_add)
        val new_name = findViewById<EditText>(R.id.new_name)
        val new_num_cuenta = findViewById<EditText>(R.id.new_num_cuenta)
        val new_correo = findViewById<EditText>(R.id.new_correo)

        button_add.setOnClickListener {
            val name = new_name.text.toString()
            val num_cuenta = new_num_cuenta.text.toString()
            val correo = new_correo.text.toString()

            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("mensaje", "nuevo alumno")
            intent2.putExtra("name", name)
            intent2.putExtra("num_cuenta", num_cuenta)
            intent2.putExtra("correo", correo)
            intent2.putExtra("foto", "https://loremflickr.com/320/240?random=10")
            startActivity(intent2)
            finish()
        }
    }
}
