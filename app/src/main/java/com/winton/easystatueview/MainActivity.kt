package com.winton.easystatueview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.winton.librarystatue.AppStatueConfig
import com.winton.librarystatue.StatueView
import com.winton.librarystatue.StatusViewFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<StatueView>(R.id.status_id).mEmptyTextRes = R.string.app_name
        findViewById<StatueView>(R.id.status_id).showLoading()
    }
}
