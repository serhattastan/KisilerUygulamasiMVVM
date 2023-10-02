package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title = "Kişiler"



        //RecyclerView

        //Linear Görünüm
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Kutucuklu Görünüm
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet", "11111")
        val k2 = Kisiler(1,"Mahmut", "22222")
        val k3 = Kisiler(1,"Rıza", "33333")
        val k4 = Kisiler(1,"Kamil", "44444")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)

        val kisilerAdapter = KisilerAdapter(requireContext(), kisilerListesi)
        binding.recyclerView.adapter = kisilerAdapter



        //Fab Button
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_kisiKayitFragment)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })

        return binding.root
    }

    fun ara(aramaKelimesi : String){
        Log.e("Kişi Ara",aramaKelimesi)
    }

}