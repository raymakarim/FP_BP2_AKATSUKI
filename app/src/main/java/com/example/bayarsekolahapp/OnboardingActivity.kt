package com.example.bayarsekolahapp // <-- Pastikan package-mu benar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

// Pastikan import R ini benar
import com.example.bayarsekolahapp.R

class OnboardingActivity : AppCompatActivity() {

    // 1. Deklarasikan semua komponen yang kita butuh
    private lateinit var viewPager: ViewPager2
    private lateinit var indicatorContainer: LinearLayout
    private lateinit var btnMulai: Button
    private lateinit var btnMasuk: Button
    private lateinit var tvLewati: TextView

    private lateinit var adapter: OnboardingAdapter
    private lateinit var guideDataList: List<GuidePageData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hubungkan ke file layout activity_onboarding.xml
        setContentView(R.layout.activity_onboarding)

        // 2. Ambil komponen dari layout (findViewById)
        viewPager = findViewById(R.id.view_pager_guide)
        indicatorContainer = findViewById(R.id.indicator_container)
        btnMulai = findViewById(R.id.btn_mulai)
        btnMasuk = findViewById(R.id.btn_masuk)
        tvLewati = findViewById(R.id.tv_skip)

        // ----------------------------------------------------
        // INI JAWABAN PERTANYAANMU:
        // Di sinilah kita membuat data untuk 3 halaman itu
        // ----------------------------------------------------
        guideDataList = listOf(
            GuidePageData(
                title = "Bayar Sekolah",
                description = "dengan mudah",
                iconResId = R.drawable.ic_guide_card // <-- Ganti nama ikonmu
            ),
            GuidePageData(
                title = "Satu Aplikasi",
                description = "untuk semua kebutuhan sekolah",
                iconResId = R.drawable.ic_guide_card // <-- Ganti nama ikonmu
            ),
            GuidePageData(
                title = "Project P",
                description = "aplikasi pembayaran sekolah",
                iconResId = R.drawable.ic_wallet // <-- Ganti nama ikonmu
            )
        )
        // ----------------------------------------------------

        // 3. "Pekerjakan" Manajer (Adapter) dan kasih data-nya
        // 'this' merujuk ke Activity ini
        adapter = OnboardingAdapter(this, guideDataList)

        // 4. Sambungkan ViewPager (Album) dengan Adapter (Manajer)
        viewPager.adapter = adapter

        // 5. Siapkan titik-titik indikator
        setupIndicatorDots(guideDataList.size)
        updateIndicatorDots(0) // Aktifkan titik pertama

        // 6. Atur listener untuk ViewPager (saat digeser)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Saat halaman digeser, update titik mana yang aktif
                updateIndicatorDots(position)
            }
        })

        // 7. Atur listener untuk tombol-tombol
        btnMulai.setOnClickListener {
            // TODO: Pindah ke halaman Daftar (Register)
            // val intent = Intent(this, RegisterActivity::class.java)
            // startActivity(intent)
        }

        btnMasuk.setOnClickListener {
            // TODO: Pindah ke halaman Masuk (Login)
            // val intent = Intent(this, LoginActivity::class.java)
            // startActivity(intent)
        }

        tvLewati.setOnClickListener {
            // TODO: Pindah ke halaman Masuk (Login) juga
            // val intent = Intent(this, LoginActivity::class.java)
            // startActivity(intent)
        }
    }

    private fun setupIndicatorDots(count: Int) {

        for (i in 0 until count) {
            val dot = View(this)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                width = 24 // ukuran titik
                height = 24 // ukuran titik
                setMargins(8, 0, 8, 0) // jarak antar titik
            }
            dot.layoutParams = params
            dot.setBackgroundResource(R.drawable.indicator_dot_inactive) // Awalnya semua abu-abu
            indicatorContainer.addView(dot)
        }
    }

    private fun updateIndicatorDots(position: Int) {
        for (i in 0 until indicatorContainer.childCount) {
            val dot = indicatorContainer.getChildAt(i)
            if (i == position) {
                dot.setBackgroundResource(R.drawable.indicator_dot_active) // Jadi hijau
            } else {
                dot.setBackgroundResource(R.drawable.indicator_dot_inactive) // Jadi abu-abu
            }
        }
    }
}