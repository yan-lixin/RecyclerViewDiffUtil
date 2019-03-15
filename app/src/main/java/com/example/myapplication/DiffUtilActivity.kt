package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.chaince.utils.extensions.clickWithTrigger
import com.example.myapplication.adapter.DiffAdapter
import com.example.myapplication.bean.DiffBean
import kotlinx.android.synthetic.main.activity_diff.*
import org.jetbrains.anko.toast

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/13
 * Description:
 */
class DiffUtilActivity: AppCompatActivity() {

    private var mList = mutableListOf<DiffBean>()
    private val mAdapter: DiffAdapter = DiffAdapter()

    private var countRefresh = 1
    private var countUpdate = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)
        initView()
        initListener()
        initData()
    }

    private fun initView() {
        rvDiff.apply {
            layoutManager = LinearLayoutManager(this@DiffUtilActivity, LinearLayoutManager.VERTICAL, false)
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
                    mAdapter.setData(mList)
                }
            }
        }

        btnUpdate.clickWithTrigger {
            val bean = mList[0]
            val diffBean = DiffBean(bean.name, "更改A $countUpdate")
            mList[0] = diffBean
            mAdapter.setData(mList)

            countUpdate++
        }

        btnDelete.clickWithTrigger {
            mList.removeAt(0)
            mAdapter.setData(mList)
        }

        btnRefresh.clickWithTrigger {
            val newList = mutableListOf<DiffBean>()
            newList.apply {
                add(DiffBean("A", "这是A--更新次数：$countRefresh"))
                add(DiffBean("B", "这是B--更新次数：$countRefresh"))
                add(DiffBean("C", "这是C--更新次数：$countRefresh"))
                add(DiffBean("D", "这是D--更新次数：$countRefresh"))
                add(DiffBean("E", "这是E--更新次数：$countRefresh"))
            }
            mAdapter.setData(newList)

            countRefresh++
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
        mAdapter.setData(mList)
    }
}