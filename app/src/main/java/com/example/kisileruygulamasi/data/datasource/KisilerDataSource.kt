package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet", "11111")
            val k2 = Kisiler(1,"Mahmut", "22222")
            val k3 = Kisiler(1,"Rıza", "33333")
            val k4 = Kisiler(1,"Kamil", "44444")
            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)
            kisilerListesi.add(k4)
            return@withContext kisilerListesi
        }
    suspend fun kaydet(kisi_ad : String, kisi_tel : String){
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }
    suspend fun guncelle(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }
    suspend fun sil(kisi_id : Int){
        Log.e("Kişi Sil", kisi_id.toString())
    }
}