package com.jash.itsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtUsuario: EditText = findViewById(R.id.txtUsuario)
        var txtpass: EditText = findViewById(R.id.txtContraseña)
        var btnIniciarSesion: Button = findViewById(R.id.btnIniciarSesion)
        fun validarDatos(){
            val usuario = txtUsuario.text
            val contraseña = txtpass.text

            if (usuario.toString().isEmpty() || contraseña.toString().isEmpty()) {
                Toast.makeText(
                    this@MainActivity, "Rellena todos los datos",
                    Toast.LENGTH_SHORT
                ) .show()
            } else{
                // en esta parte indicamos otra pantalla
                if (usuario.toString() == "admin" && contraseña.toString() == "1") {
                    val intent = Intent(this, MenuActivity::class.java)
                    intent.putExtra("Usuario", usuario.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(
                        this@MainActivity, "Datos incorrectos",
                        Toast.LENGTH_SHORT
                    ) .show()
                }
            }
            //Toast.makeText(this@MainActivity,usuario,Toast.LENGTH_SHORT).show()
        }

        btnIniciarSesion.setOnClickListener {
            validarDatos()
        }
    }
}