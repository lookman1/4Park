package belajar.android.a4park.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import belajar.android.a4park.databinding.ItemRambuBinding
import belajar.android.a4park.model.ModelLarangan
import com.bumptech.glide.Glide


class RvRambuLarangan : RecyclerView.Adapter<RvRambuLarangan.DataRambuLarangan>() {
    private var mFilteredList= mutableListOf<ModelLarangan>()
    private var mArrayList= mutableListOf<ModelLarangan>()
    lateinit var context: Context

    fun initData(data:List<ModelLarangan>){
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
    ): DataRambuLarangan {
        val binding= ItemRambuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataRambuLarangan(binding)
    }

    override fun onBindViewHolder(holder: DataRambuLarangan, position: Int) {
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

    inner class DataRambuLarangan(val binding:ItemRambuBinding): RecyclerView.ViewHolder(binding.root)

}