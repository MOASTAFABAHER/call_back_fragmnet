package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ContactMenuAdapter
    lateinit var itemList:MutableList<contactItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.Recycler_view_id)
        createContactsItem()
        adapter= ContactMenuAdapter(itemList)
        adapter.onItemClickListner=object:ContactMenuAdapter.OnItemClickListner{
            override fun onItemClick(position: Int, items: contactItem) {
                val intent=Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(intent)

            }

        }

        recyclerView.adapter=adapter
    }

    private fun createContactsItem() {
        itemList= mutableListOf()
        for (i in 0..1){
            itemList.add(contactItem(R.drawable.ic_baseline_person_24,"mostafa","2222"))
            itemList.add(contactItem(R.drawable.ic_baseline_person_24,"mostafa", "210"))
            itemList.add(contactItem(R.drawable.ic_baseline_person_24,"mostafa",  "10000")) }
    }
}
