package com.winton.librarystatue

/**
 * @author: winton
 * @time: 2018/9/29 下午4:01
 * @desc: StatueView的方法
 */
interface IStatueView {

    companion object {
       const val STATUS_CONTENT = 0x01
       const val STATUS_LOADING = 0x02
       const val STATUS_EMPTY = 0x03
       const val STATUS_ERROR = 0x04
       const val STATUS_NO_NETWOEK = 0x05
    }

    /**
     * 显示加载中
     */
    fun showLoading()

    /**
     * 显示异常
     */
    fun showError()

    /**
     * 显示无数据
     */
    fun showEmpty()

    /**
     * 显示内容
     */
    fun showContent()

    /**
     * 显示无网络
     */
    fun showNoNetwork()

}