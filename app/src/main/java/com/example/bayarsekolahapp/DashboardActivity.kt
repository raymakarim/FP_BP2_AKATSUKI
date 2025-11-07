package com.example.bayarsekolahapp

import android.os.Bundle
import android.widget.Toast // Tambahkan ini untuk tes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bayarsekolahapp.R
import com.example.bayarsekolahapp.Student
import com.example.bayarsekolahapp.StudentAdapter

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var studentList: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Setup Toolbar
        val toolbar: com.google.android.material.appbar.MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recycler_view_students)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadData()

        // 1. <-- DIUBAH: Saat buat Adapter, kita selipkan fungsi "laporan balik"
        adapter = StudentAdapter(studentList) { clickedStudent ->
            // Kode ini akan jalan SETIAP KALI user nge-klik satu baris
            handleStudentClick(clickedStudent)
        }

        recyclerView.adapter = adapter
    }

    // 2. <-- TAMBAHAN: Ini adalah LOGIKA UTAMA (yang dulu di adapter)
    private fun handleStudentClick(clickedStudent: Student) {

        // --- INI DIA BAGIAN "FUTURE PROOF"-NYA ---
        // 'clickedStudent' adalah "Nahida", "Betano", dll.
        // Karena logikanya ada di Activity, kamu bisa panggil database-mu DI SINI:

        // loadDataPembayaran(clickedStudent.id)
        // Toast.makeText(this, "Kamu memilih: ${clickedStudent.name}", Toast.LENGTH_SHORT).show()

        // ---

        // --- Logika "Radio Button" (sekarang pindah ke "Bos") ---

        // 1. Matikan semua centang di 'studentList' (data mentahnya)
        studentList.forEach { student ->
            student.isChecked = false
        }

        // 2. Nyalakan centang HANYA untuk 'clickedStudent'
        clickedStudent.isChecked = true

        // 3. Suruh adapter gambar ulang seluruh list
        // (Karena data di 'studentList' sudah kita ubah)
        adapter.notifyDataSetChanged()
    }


    private fun loadData() {
        studentList = mutableListOf(
            Student("Betan", "XI - MIPA", true),
            Student("Nahida", "VI - Ilmu Perhutanan", false),
            Student("Kaoruko-Chan", "X - Bahasa", false)
        )
    }
}