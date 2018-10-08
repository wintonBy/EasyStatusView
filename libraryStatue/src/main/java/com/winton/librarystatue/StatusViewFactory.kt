package com.winton.librarystatue

/**
 * @author: winton
 * @time: 2018/9/29 下午6:00
 * @desc: 描述
 */

class StatusViewFactory{

    companion object {

        private val appConfig = AppStatueConfig()

        fun appConfig():AppStatueConfig{
            return appConfig
        }


    }


}