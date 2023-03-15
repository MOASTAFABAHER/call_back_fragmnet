package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactMenuAdapter(val items:List<contactItem>):RecyclerView.Adapter<ContactMenuAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myItem= items[position]
        holder.name.text=myItem.name
        holder.phoneNumber.text=myItem.phoneNumber
        myItem.ImageID.let { holder.image.setImageResource(it) }
        holder.image.setOnClickListener { if(onItemClickListner!=null){
        onItemClickListner?.onItemClick(position,items[position])
        }
        }
    }
    var onItemClickListner:OnItemClickListner?=null
    interface  OnItemClickListner{
    fun  onItemClick(position: Int,items:contactItem)

}

    override fun getItemCount(): Int{
        return items.size
    }

    class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name_id)
        val  phoneNumber:TextView=itemView.findViewById(R.id.phone_id)
        val image : ImageView = itemView.findViewById(R.id.image_id)
    }

}