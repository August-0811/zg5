package com.example.day005_zhuoye

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.RelativeLayout as RelativeLayout1

class MyAdapter(private var mContext:Context,private var mList:List<TextBean>?):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val mLayoutInflater:LayoutInflater = LayoutInflater.from(mContext)
    private var mClickListenter: AdapterView.OnItemClickListener? = null

    fun setOnItemClickListenter(listener:AdapterView.OnItemClickListener) {
        this.mClickListenter = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mLayoutInflater.inflate(R.layout.item_test,parent,false)
        val viewHolder = ViewHolder(view)


        return viewHolder
    }

    override fun getItemCount(): Int {
        return mList?.size ?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.test.text = mList!![position].name
    }


    inner class ViewHolder(itemViwe:View):RecyclerView.ViewHolder(itemViwe){
        var layout:RecyclerView
        var test:TextView

        init {
            this.layout = itemViwe.findViewById(R.id.rec)
            this.test = itemViwe.findViewById(R.id.text) as TextView
        }

    }
}