package com.example.bayarsekolahapp

data class Bill(
    val title: String,      // Contoh: "SPP XII", "Kursus Bahasa China"
    val description: String, // Contoh: "Bulanan - 450.000"
    val amount: String      // Contoh: "Rp 450.000" (Opsional, jika ingin memisahkan harga)
    // Anda bisa menambahkan status pembayaran: val isPaid: Boolean
)