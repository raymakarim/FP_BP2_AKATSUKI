package com.example.bayarsekolahapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bayarsekolahapp.R

// 1. <-- DIUBAH: Adapter sekarang minta "laporan balik" (onItemClick)
class StudentAdapter(
    private val studentList: List<Student>,
    private val onItemClick: (Student) -> Unit // Ini adalah "laporan" ke Bos
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // --- Variabel 'selectedPosition' kita HAPUS dari sini ---

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_student_name)
        val tvClass: TextView = itemView.findViewById(R.id.tv_student_class)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox_student)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.name
        holder.tvClass.text = student.classInfo

        // 2. <-- DIUBAH: Checkbox sekarang murni 100% nurut sama data
        holder.checkBox.isChecked = student.isChecked

        // 3. <-- DIUBAH: Buat SELURUH BARIS bisa diklik
        // Logika "radio button" dihapus dari sini
        holder.itemView.setOnClickListener {
            onItemClick(student) // "Lapor ke Bos, 'student' ini baru diklik!"
        }
    }
}