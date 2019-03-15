package com.example.myapplication.adapter

import android.support.v7.recyclerview.extensions.AsyncListDiffer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.bean.DiffBean
import com.example.myapplication.callback.DiffItemCallback
import com.example.myapplication.viewholder.DiffViewHolder
import kotlinx.android.synthetic.main.activity_diff.view.*

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class AsyncListDiffAdapter: RecyclerView.Adapter<DiffViewHolder>() {

    val mAld = AsyncListDiffer<DiffBean>(this, DiffItemCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffViewHolder {
        return DiffViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_diff, parent, false))
    }

    override fun getItemCount(): Int {
        return mAld.currentList.size
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int) {
        with(mAld.currentList[position]) {
            holder.itemView.tvName.text = name
            holder.itemView.tvDesc.text = desc
        }
    }

    fun submitList(list: List<DiffBean>?) {
        mAld.submitList(list)
    }
}