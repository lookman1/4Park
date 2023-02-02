package belajar.android.a4park.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import belajar.android.a4park.databinding.ItemRambuBinding
import belajar.android.a4park.model.ModelHimbauan
import com.bumptech.glide.Glide


class RvRambuHimbauan : RecyclerView.Adapter<RvRambuHimbauan.DataRambuHimbauan>() {
    private var mFilteredList= mutableListOf<ModelHimbauan>()
    private var mArrayList= mutableListOf<ModelHimbauan>()
    lateinit var context: Context

    fun initData(data:List<ModelHimbauan>){
        mFilteredList.clear()
        mArrayList.clear()
        mFilteredList.addAll(data)
        mArrayList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData(){
        mFilteredList.clear()
        mArrayList.clear()
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataRambuHimbauan {
        val binding= ItemRambuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataRambuHimbauan(binding)
    }

    override fun onBindViewHolder(holder: DataRambuHimbauan, position: Int) {
        with(holder){
            with(mFilteredList[position]){
                // pengambilan data
                binding.txRambu.text = keterangan
                Glide.with(context).load(image).into(binding.imgRambu)

                // Perintah saat klik item
                binding.root.setOnClickListener {
                    // Perintah memunculkan toast dengan data
                    // Toast.makeText(context,binding.judul.text,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    inner class DataRambuHimbauan(val binding:ItemRambuBinding): RecyclerView.ViewHolder(binding.root)

}