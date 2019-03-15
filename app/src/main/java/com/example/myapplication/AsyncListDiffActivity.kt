package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.chaince.utils.extensions.clickWithTrigger
import com.example.myapplication.adapter.AsyncListDiffAdapter
import com.example.myapplication.bean.DiffBean
import kotlinx.android.synthetic.main.activity_async_list_differ.*
import org.jetbrains.anko.toast

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/15
 * Description:
 */
class AsyncListDiffActivity: AppCompatActivity() {

    private var mList = mutableListOf<DiffBean>()
    private val mAdapter = AsyncListDiffAdapter()

    private var countUpdate = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_list_differ)

        initView()
        initListener()
        initData()
    }

    private fun initView() {
        rvDiff.apply {
            layoutManager = LinearLayoutManager(this@AsyncListDiffActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
    }

    private fun initListener() {
        btnAdd.clickWithTrigger {
            when {
                TextUtils.isEmpty(editName.text) -> toast(editName.hint)
                TextUtils.isEmpty(editDesc.text) -> toast(editDesc.hint)
                else -> {
                    val bean = DiffBean(editName.text.toString(), editDesc.text.toString())
                    mList.add(bean)
                    val newList = mutableListOf<DiffBean>()
                    newList.addAll(mList)
                    mAdapter.submitList(newList)
                }
            }
        }

        btnUpdate.clickWithTrigger {
            val bean = mList[0]
            val diffBean = DiffBean(bean.name, "更改A $countUpdate")
            mList[0] = diffBean
            val newList = mutableListOf<DiffBean>()
            newList.addAll(mList)
            mAdapter.submitList(newList)

            countUpdate ++
        }

        btnDelete.clickWithTrigger {
            mList.removeAt(0)
            val newList = mutableListOf<DiffBean>()
            newList.addAll(mList)
            mAdapter.submitList(newList)
        }

        btnClear.clickWithTrigger {
            mAdapter.submitList(null)
        }
    }

    private fun initData() {
        mList.apply {
            add(DiffBean("A", "这是A"))
            add(DiffBean("B", "这是B"))
            add(DiffBean("C", "这是C"))
            add(DiffBean("D", "这是D"))
            add(DiffBean("E", "这是E"))
        }
        val newList = mutableListOf<DiffBean>()
        newList.addAll(mList)
        mAdapter.submitList(newList)
    }
}