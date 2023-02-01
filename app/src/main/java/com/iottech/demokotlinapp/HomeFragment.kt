package com.iottech.demokotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iottech.demokotlinapp.databinding.FragmentHomeBinding
import com.iottech.demokotlinapp.retro.ApiClient
import com.iottech.demokotlinapp.retro.ApiInterface
import com.iottech.demokotlinapp.retro.OnRecycler
import com.iottech.testkotlinrecyclerview.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    lateinit var homeBinding : FragmentHomeBinding
    private lateinit var productList : MutableList<ProductsModel>
//    private lateinit var recyclerview : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        homeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        productList = ArrayList()
        getUsersDetails()
        return homeBinding.root
    }

    private fun getUsersDetails() {
        productList.clear()
        val retrofit = ApiClient.getClient()
        val retrofitAPI: ApiInterface = retrofit.create(ApiInterface::class.java)
        val call: Call<ProductsModel> = retrofitAPI.getusers()
        call.enqueue(object : Callback<ProductsModel> {
            override fun onResponse(call: Call<ProductsModel>, response: Response<ProductsModel>) {
                if (response.isSuccessful){
                    Toast.makeText(context, "server code "+ response.body()!!.status, Toast.LENGTH_SHORT).show()

                    for (i in 0 until response.body()!!.trending.size){
                        productList.add(ProductsModel(
                            response.body()!!.commingSoon,response.body()!!.trending,response.body()!!.onSale,response.body()!!.bannerImage
                        ))
                    }

                    val layoutManager = LinearLayoutManager(context)
                    homeBinding.recyclerview.layoutManager = layoutManager
                    homeBinding.recyclerview.setHasFixedSize(true)
                    val adapter = context?.let {
                        RecyclerAdapter(productList, it, OnRecycler {
                            Toast.makeText(context, ""+ productList.get(it).trending.get(it).name, Toast.LENGTH_SHORT).show()
                        })
                    }
                    homeBinding.recyclerview.adapter = adapter

                }else{
                    Toast.makeText(context, "Something went wrong ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProductsModel>, t: Throwable) {

            }
        })


    }

}