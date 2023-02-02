package belajar.android.a4park.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import belajar.android.a4park.databinding.ItemRambuBinding
import belajar.android.a4park.model.ModelPeringatan
import com.bumptech.glide.Glide


class RvRambuPeringatan : RecyclerView.Adapter<RvRambuPeringatan.DataRambuPeringatan>() {
    private var mFilteredList= mutableListOf<ModelPeringatan>()
    private var mArrayList= mutableListOf<ModelPeringatan>()
    lateinit var context: Context

    fun initData(data:List<ModelPeringatan>){
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
    ): DataRambuPeringatan {
        val binding= ItemRambuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataRambuPeringatan(binding)
    }

    override fun onBindViewHolder(holder: DataRambuPeringatan, position: Int) {
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

    inner class DataRambuPeringatan(val binding:ItemRambuBinding): RecyclerView.ViewHolder(binding.root)

}