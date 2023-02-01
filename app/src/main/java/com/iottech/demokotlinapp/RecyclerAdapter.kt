package com.iottech.testkotlinrecyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iottech.demokotlinapp.ModelList
import com.iottech.demokotlinapp.ProductsModel
import com.iottech.demokotlinapp.R
import com.iottech.demokotlinapp.retro.ApiClient
import com.iottech.demokotlinapp.retro.OnRecycler
import com.squareup.picasso.Picasso

 class RecyclerAdapter(private val mList: List<ProductsModel>, val context: Context, val onrecycler: OnRecycler) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listModel: ProductsModel = mList.get(position)
        holder.productName.text = listModel.trending.get(position).name
        holder.productPrice.text = listModel.trending.get(position).price
        val imgUrl = ApiClient.BASE_URL+listModel.trending.get(position).primaryImage
        Picasso.get().load(imgUrl).into(holder.imageView)
       holder.itemView.setOnClickListener(){
           onrecycler.onClick(position)
       }

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = ItemView.findViewById(R.id.imageview)
        val productName: TextView = ItemView.findViewById(R.id.productname)
        val productPrice: TextView = ItemView.findViewById(R.id.productPrice)
    }
}