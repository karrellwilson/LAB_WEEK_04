package com.example.lab_week_04 // Pastikan package name sesuai

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(
    // Tambahkan parameter ini untuk menerima daftar deskripsi
    private val tabContents: List<String>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    // Jumlah halaman/tab sekarang didasarkan pada jumlah deskripsi
    override fun getItemCount(): Int {
        return tabContents.size
    }

    // Buat fragment dengan deskripsi yang sesuai
    override fun createFragment(position: Int): Fragment {
        return CafeDetailFragment.newInstance(tabContents[position])
    }
}