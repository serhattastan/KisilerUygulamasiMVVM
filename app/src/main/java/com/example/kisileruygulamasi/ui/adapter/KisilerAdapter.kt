package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext : Context, var kisilerListesi : List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>() {
    inner class CardTasarimHolder(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim, parent, false)
        return CardTasarimHolder(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.kisiNesnesi = kisi

        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToKisiDetayFragment(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    kisiSil(kisi.kisi_id)
                }
                .show()
        }

    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    fun kisiSil(kisi_id : Int){
        Log.e("Kişi Sil", kisi_id.toString())
    }
}