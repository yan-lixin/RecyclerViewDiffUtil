package com.example.myapplication.callback

import android.os.Bundle
import android.support.v7.util.DiffUtil
import com.example.myapplication.bean.DiffBean
import com.example.myapplication.global.KEY_DESC

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/13
 * Description:
 */
class DiffCallback(private val oldList: List<DiffBean>, private val newList: List<DiffBean>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldBean = oldList[oldItemPosition]
        val newBean = newList[newItemPosition]

        if (oldBean.desc != newBean.desc) {
            return false
        }
        return true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldBean = oldList[oldItemPosition]
        val newBean = newList[newItemPosition]

        val bundle = Bundle()
        if (oldBean.desc != newBean.desc) {
            bundle.putString(KEY_DESC, "getChangePayLoad ${newBean.desc}")
        } else {
            return null
        }
        return bundle
    }
}