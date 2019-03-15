package com.example.myapplication.adapter

import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.bean.StudentBean
import com.example.myapplication.callback.SortedCallback
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class StudentAdapter: RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    val mCallback = SortedCallback(this)
    val mSortedList = SortedList<StudentBean>(StudentBean::class.java, SortedList.BatchedCallback<StudentBean>(mCallback))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun getItemCount(): Int {
        return mSortedList.size()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(mSortedList[position]) {
            holder.itemView.tvNoValue.text = no.toString()
            holder.itemView.tvNameValue.text = name
            holder.itemView.tvRankValue.text = rank.toString()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }
}