package com.example.res

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class foodAdapter (val foodList: List<Food>) :
        RecyclerView.Adapter<foodAdapter.ViewHolder>(){

//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val foodImage: ImageView = view.findViewById(R.id.foodImage)
//        val foodName: TextView = view.findViewById(R.id.foodName)
//    }

    inner class ViewHolder(inflater: LayoutInflater, parent:ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.food_item, parent, false)){
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)

        fun bind(food : Food){
            foodImage?.setImageResource(food.imageId)
            foodName?.text = food.name
        }
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
//        val holder = ViewHolder(view)
//
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return ViewHolder(inflater, parent)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.food_item, parent, false)
//        return ViewHolder(view)
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
    }

    override fun getItemCount() = foodList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }
}