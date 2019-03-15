package com.example.myapplication.adapter

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.bean.DiffBean
import com.example.myapplication.callback.DiffCallback
import com.example.myapplication.global.KEY_DESC
import com.example.myapplication.viewholder.DiffViewHolder
import kotlinx.android.synthetic.main.activity_diff.view.*

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/13
 * Description:
 */
class DiffAdapter: RecyclerView.Adapter<DiffViewHolder>() {

    val data: MutableList<DiffBean> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diff, parent, false)
        return DiffViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            val bundle = payloads[0] as Bundle
            holder.itemView.tvDesc.text = bundle.getString(KEY_DESC)
        }
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int) {
        with(data[position]) {
            holder.itemView.tvName.text = name
            holder.itemView.tvDesc.text = desc
        }
    }

    fun setData(data: List<DiffBean>) {
        val result: DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallback(this.data, data), true)

        result.dispatchUpdatesTo(this)
        this.data.clear()
        this.data.addAll(data)
    }

}