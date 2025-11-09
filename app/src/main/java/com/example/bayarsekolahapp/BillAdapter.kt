package com.example.bayarsekolahapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BillAdapter(private val billList: List<Bill>) :
    RecyclerView.Adapter<BillAdapter.BillViewHolder>() {

    // 1. ViewHolder: Menghubungkan variabel dengan komponen UI di bill_item_row.xml
    inner class BillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvBillTitle)
        val tvDetails: TextView = itemView.findViewById(R.id.tvBillDetails)
        val ivDownload: ImageView = itemView.findViewById(R.id.ivDownload)
        // Jika Anda ingin itemnya bisa diklik:
        // val itemViewContainer: View = itemView
    }

    // 2. onCreateViewHolder: Membuat dan menginflate layout baris
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bill_item_row, parent, false)
        return BillViewHolder(view)
    }

    // 3. onBindViewHolder: Mengisi data ke dalam komponen UI
    override fun onBindViewHolder(holder: BillViewHolder, position: Int) {
        val currentItem = billList[position]

        holder.tvTitle.text = currentItem.title
        holder.tvDetails.text = currentItem.description

        // Logika tampilan untuk item yang sudah dibayar/belum, dll. (Jika Anda menambahkannya)
    }

    // 4. getItemCount: Memberi tahu RecyclerView berapa banyak item yang ada
    override fun getItemCount() = billList.size
}