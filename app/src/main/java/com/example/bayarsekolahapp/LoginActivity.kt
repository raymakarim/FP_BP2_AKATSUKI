package com.example.bayarsekolahapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnMasuk = findViewById<Button>(R.id.btnMasuk)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnPonsel = findViewById<Button>(R.id.btnPonsel)

        // Contoh aksi klik tombol Masuk
        btnMasuk.setOnClickListener {
            Toast.makeText(this, "Tombol Masuk Ditekan", Toast.LENGTH_SHORT).show()
            // Tambahkan logika validasi email dan password disini
        }

        // Toggle tombol Email dan Ponsel (contoh)
        btnEmail.setOnClickListener {
            btnEmail.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            btnEmail.setTextColor(resources.getColor(android.R.color.white))
            btnPonsel.setBackgroundColor(resources.getColor(android.R.color.white))
            btnPonsel.setTextColor(resources.getColor(android.R.color.black))
            // Tambahkan logika apabila ingin ganti form input
        }

        btnPonsel.setOnClickListener {
            btnPonsel.setBackgroundColor(resources.getColor(android.R.color.white))
            btnPonsel.setTextColor(resources.getColor(android.R.color.black))
            btnEmail.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            btnEmail.setTextColor(resources.getColor(android.R.color.white))
            // Tambahkan logika apabila ingin ganti form input
        }
    }
}
