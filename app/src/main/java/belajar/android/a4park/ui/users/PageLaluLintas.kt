package belajar.android.a4park.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import belajar.android.a4park.R
import belajar.android.a4park.adapter.RvRambuHimbauan
import belajar.android.a4park.adapter.RvRambuLarangan
import belajar.android.a4park.adapter.RvRambuPeringatan
import belajar.android.a4park.databinding.ActivityLaluLintasBinding
import belajar.android.a4park.model.ModelHimbauan
import belajar.android.a4park.model.ModelLarangan
import belajar.android.a4park.model.ModelPeringatan

class PageLaluLintas : AppCompatActivity() {
    private lateinit var binding: ActivityLaluLintasBinding
    val RvRambuPeringatan = RvRambuPeringatan()
    val RvRambuLarangan = RvRambuLarangan()
    val RvRambuHimbauan = RvRambuHimbauan()
    val dataRambuPeringatan = ArrayList<ModelPeringatan>()
    val dataRambuLarangan = ArrayList<ModelLarangan>()
    val dataRambuHimbauan = ArrayList<ModelHimbauan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaluLintasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //--------------------------------------------------------------------------//
        //Insert Data
        //Rambu Peringatan
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.zebra_cross,"Zebra Cross"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.tanjakan,"Tanjakan Terjal"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.turunan,"Turunan Curam"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.penyempitan,"Penyempitan Jalam di Jembatan"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.tikungankanan,"Hati-hati Tikungan Kekanan"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.tikungankiri,"Hati-hati Tikungan Kekiri"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.tikungantajam,"Hati-hati Tikungan Tajam"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.jalancembung,"Jalan Cembung"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.jalanlicin,"Jalan Licin"))
        dataRambuPeringatan.add(ModelPeringatan(R.drawable.longsor,"Jalan Rawan Longsor"))

        
        //Rambu Larangan
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))
        dataRambuLarangan.add(ModelLarangan(R.drawable.parkir,"Dilarang Parkir"))


        //RambuHimbauan
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.jalur,"Gunakan Jalur Kanan"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.jalurkiri,"Gunakan Jalur Kiri"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.muter,"Ikuti Arah yang Ditentukan Pada Bundaran"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.arahkanan,"Gunakan Arah Kiri"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.arahkiri,"Gunakan Arah Kanan "))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.lurus,"Lurus Terus"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.luruskanan,"Lurus Atau Kanan"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.luruskiri,"Lurus Atau Kiri"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.belokkanan,"Belok Kanan"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.belokkiri,"Belok Kiri"))
        dataRambuHimbauan.add(ModelHimbauan(R.drawable.jalurpejalankaki,"Jalur Khusus Pejalan Kaki"))

        //--------------------------------------------------------------------------//
        
        //Layout RecyclerView
        binding.RvPeringatan.apply {
            layoutManager = LinearLayoutManager (this@PageLaluLintas, LinearLayoutManager.HORIZONTAL, false)
            adapter = RvRambuPeringatan
        }
        binding.RvLarangan.apply {
            layoutManager = LinearLayoutManager (this@PageLaluLintas, LinearLayoutManager.HORIZONTAL, false)
            adapter = RvRambuLarangan
        }
        binding.RvHimbauan.apply {
            layoutManager = LinearLayoutManager (this@PageLaluLintas, LinearLayoutManager.HORIZONTAL, false)
            adapter = RvRambuHimbauan
        }


        //Input Data
        RvRambuPeringatan.initData(dataRambuPeringatan)
        RvRambuLarangan.initData(dataRambuLarangan)
        RvRambuHimbauan.initData(dataRambuHimbauan)
    }
}