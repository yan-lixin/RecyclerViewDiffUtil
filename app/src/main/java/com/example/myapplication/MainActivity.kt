package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaince.utils.extensions.clickWithTrigger
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        diffUtilBtn.clickWithTrigger {
            startActivity<DiffUtilActivity>()
        }

        asyncListDifferBtn.clickWithTrigger {
            startActivity<AsyncListDiffActivity>()
        }

        listAdapterBtn.clickWithTrigger {
            startActivity<ListAdapterActivity>()
        }

        sortedListBtn.clickWithTrigger {
            startActivity<SortedListActivity>()
        }
    }
}
