package com.example.myapplication.callback

import android.support.v7.util.DiffUtil
import com.example.myapplication.bean.DiffBean

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class DiffItemCallback: DiffUtil.ItemCallback<DiffBean>() {

    override fun areItemsTheSame(oldItem: DiffBean, newItem: DiffBean): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DiffBean, newItem: DiffBean): Boolean {
        if (oldItem.desc != newItem.desc) {
            return false
        }
        return true
    }

}