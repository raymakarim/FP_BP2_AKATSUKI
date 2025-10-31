package com.example.bayarsekolahapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class GuideFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guide_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(KEY_TITLE)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(KEY_ICON) ?: 0 // Beri 0 sebagai default

        val ivIcon: ImageView = view.findViewById(R.id.iv_guide_icon)
        val tvTitle: TextView = view.findViewById(R.id.tv_guide_title)
        val tvDescription: TextView = view.findViewById(R.id.tv_guide_description)

        if (iconResId != 0) {
            ivIcon.setImageResource(iconResId)
        }
        tvTitle.text = title
        tvDescription.text = description
    }

    companion object {
        // Kunci (key) untuk menyimpan dan mengambil data
        private const val KEY_TITLE = "title"
        private const val KEY_DESCRIPTION = "description"
        private const val KEY_ICON = "iconResId"

        fun newInstance(title: String, description: String, iconResId: Int): GuideFragment {
            val fragment = GuideFragment()


            val args = Bundle().apply {
                putString(KEY_TITLE, title)
                putString(KEY_DESCRIPTION, description)
                putInt(KEY_ICON, iconResId)
            }

            fragment.arguments = args
            return fragment
        }
    }
}