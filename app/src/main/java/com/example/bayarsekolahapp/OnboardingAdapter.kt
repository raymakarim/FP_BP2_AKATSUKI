package com.example.bayarsekolahapp // <-- Pastikan package-mu benar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Ini adalah "Manajer" (Adapter).
 * Tugasnya adalah membuatkan Fragment yang benar untuk setiap halaman.
 */
class OnboardingAdapter(
    activity: FragmentActivity,
    private val guideItems: List<GuidePageData> // Daftar data kita
) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {
        return guideItems.size // -> return 3
    }

    override fun createFragment(position: Int): Fragment {

        val currentData = guideItems[position]

        return GuideFragment.newInstance(
            title = currentData.title,
            description = currentData.description,
            iconResId = currentData.iconResId
        )
    }
}

data class GuidePageData(
    val title: String,
    val description: String,
    val iconResId: Int
)