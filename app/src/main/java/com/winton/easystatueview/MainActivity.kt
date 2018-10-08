package com.winton.easystatueview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.winton.librarystatue.IStatueListener
import com.winton.librarystatue.StatueView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<StatueView>(R.id.statue_empty).apply {
            this.mRetryListener = object :IStatueListener{
                override fun onRetry() {
                    showLoading()
                    Toast.makeText(context,"do retry",Toast.LENGTH_SHORT).show()
                    this@apply.postDelayed(Runnable { showContent() },2000)
                }
            }
            this.showEmpty()

        }
        findViewById<StatueView>(R.id.statue_error).showError()
        findViewById<StatueView>(R.id.statue_loading).showLoading()
        findViewById<StatueView>(R.id.statue_no_net).apply {
            this.mNoNetworkTextRes = R.string.str2
            this.showNoNetwork()
        }


        findViewById<StatueView>(R.id.statue_content).showContent()


    }
}
