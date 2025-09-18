package com.example.lab_week_04 // Pastikan package name sesuai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        // Siapkan daftar deskripsi dari strings.xml
        val tabContents = TABS_CONTENT.map { resources.getString(it) }

        // Berikan daftar deskripsi ke adapter saat dibuat
        val adapter = CafeAdapter(tabContents, childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(TABS_TITLES[position])
        }.attach()
    }

    companion object {
        val TABS_TITLES = listOf(
            R.string.starbucks_title,
            R.string.janji_jiwa_title,
            R.string.kopikenangan_title
        )
        // Buat daftar baru untuk konten/deskripsi
        val TABS_CONTENT = listOf(
            R.string.starbucks_desc,
            R.string.janji_jiwa_desc,
            R.string.kopikenangan_desc
        )
    }
}