package com.example.bayarsekolahapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Import binding atau findViewById jika diperlukan

class VerifikasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi) // Memanggil layout yang benar

        // menambahkan logika untuk:
        // 1. Mendapatkan referensi EditText untuk input OTP
        // 2. Menambahkan listener ke tombol Kirim Ulang dan Selanjutnya
        // 3. Logika untuk memverifikasi kode OTP
    }
}