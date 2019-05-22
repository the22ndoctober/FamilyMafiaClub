package com.example.examplefloppy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examplefloppy.adapters.CustomAdapter
import com.example.examplefloppy.entities.Player
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var array = mutableListOf(
            Player("Floppy", "Targaryen", 0.5),
            Player("Seezov", "Targaryen", 0.7),
            Player("Fantazer", "Stark", 0.1),
            Player("Игривый", "Targaryen", 0.9)
        )
        var adapter = CustomAdapter(array)

        buttonAdd.setOnClickListener {
            array.add(Player("TEST","Xyevii", 0.8))
            adapter.notifyDataSetChanged()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
