package com.example.examplefloppy.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examplefloppy.R
import com.example.examplefloppy.entities.Player

class CustomAdapter(private val players: MutableList<Player>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = players[position].name
        holder.txtFaculty.text = players[position].faculty
        holder.txtWinRate.text = "${players[position].winRate * 100}%"
        holder.btnRemove.setOnClickListener {
            players.removeAt(position)
            notifyDataSetChanged()
        }
        holder.imgSign.setBackgroundResource(getFacSign(players[position].faculty))


    }

    private fun getFacSign(facultyName: String): Int = when (facultyName) {
        "Targaryen" -> R.drawable.targ
        "Stark" -> R.drawable.stark
        else -> 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtFaculty: TextView = itemView.findViewById(R.id.txtFaculty)
        val txtWinRate: TextView = itemView.findViewById(R.id.txtWinRate)
        val btnRemove: Button = itemView.findViewById(R.id.btnRemove)
        val imgSign: ImageView = itemView.findViewById(R.id.imgSign)
    }

}