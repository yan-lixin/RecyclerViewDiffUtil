package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.chaince.utils.extensions.clickWithTrigger
import com.example.myapplication.adapter.StudentAdapter
import com.example.myapplication.bean.StudentBean
import kotlinx.android.synthetic.main.activity_sorted_list.*

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class SortedListActivity: AppCompatActivity() {

    private val mAdapter = StudentAdapter()
    private val mList = mutableListOf<StudentBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorted_list)
        initView()
        initListener()
        initData()
    }

    private fun initView() {
        rvSorted.apply {
            layoutManager = LinearLayoutManager(this@SortedListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
    }

    private fun initListener() {
        btnNo.clickWithTrigger {
            mAdapter.mCallback.setType(SortedType.NO)
            resetData()
        }

        btnNoReverse.clickWithTrigger {
            mAdapter.mCallback.setType(SortedType.NO_REVERSE)
            resetData()
        }

        btnRank.clickWithTrigger {
            mAdapter.mCallback.setType(SortedType.RANK)
            resetData()
        }

        btnRankReverse.clickWithTrigger {
            mAdapter.mCallback.setType(SortedType.RANK_REVERSE)
            resetData()
        }
    }

    private fun initData() {
        val length = 200
        mList.apply {
            for (i in 1..length) {
                if (i == 2 || i== 3) { //验证去重
                    mList.add(StudentBean(2, "A - $i", length + 1 - i))
                } else {
                    mList.add(StudentBean(i, "A - $i", length + 1 - i))
                }
            }
        }

        mAdapter.mSortedList.beginBatchedUpdates()
        mAdapter.mSortedList.addAll(mList.toTypedArray(), false)
        mAdapter.mSortedList.endBatchedUpdates()
    }

    private fun resetData() {
        with(mAdapter.mSortedList) {
            beginBatchedUpdates()
            clear()
            mAdapter.notifyDataSetChanged()
            addAll(mList)
            endBatchedUpdates()
        }
    }

    enum class SortedType {
        NO, NO_REVERSE, RANK, RANK_REVERSE
    }
}