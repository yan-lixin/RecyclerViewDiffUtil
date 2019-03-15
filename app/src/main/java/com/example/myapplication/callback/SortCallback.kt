package com.example.myapplication.callback

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.util.SortedListAdapterCallback
import com.example.myapplication.SortedListActivity
import com.example.myapplication.bean.StudentBean

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class SortedCallback<R: RecyclerView.ViewHolder, T: RecyclerView.Adapter<R>>(private val adapter: T): SortedListAdapterCallback<StudentBean>(adapter) {

    //默认学号排序
    private var sortedType = SortedListActivity.SortedType.RANK

    override fun areItemsTheSame(bean1: StudentBean?, bean2: StudentBean?): Boolean {
        return bean1?.no == bean2?.no
    }

    override fun compare(bean1: StudentBean?, bean2: StudentBean?): Int {
        //排序条件
        return when(sortedType) {
            SortedListActivity.SortedType.NO -> bean1!!.no - bean2!!.no
            SortedListActivity.SortedType.NO_REVERSE -> bean2!!.no - bean1!!.no
            SortedListActivity.SortedType.RANK -> bean1!!.rank - bean2!!.rank
            SortedListActivity.SortedType.RANK_REVERSE -> bean2!!.rank - bean1!!.rank
        }
    }

    /**
     * 判断两个Item的内容是否相同
     */
    override fun areContentsTheSame(oldItem: StudentBean?, newItem: StudentBean?): Boolean {
        return oldItem == newItem
    }

    /**
     * 设置排序类型
     */
    fun setType(type: SortedListActivity.SortedType) {
        this.sortedType = type
    }
}