package com.winton.librarystatue

/**
 * @author: winton
 * @time: 2018/9/29 下午5:34
 * @desc: App状态配置类
 */
class AppStatueConfig {
    /**
     * empty 图标
     */
    var mEmptyViewIconRes = -1
    get() {
        if(field == -1){
            return R.mipmap.empty
        }
        return field
    }
    /**
     * empty 文本提示
     */
    var mEmptyTextRes = -1
    get() {
        if(field == -1){
            return R.string.empty_tip
        }
        return field
    }
    private set

    /**
     * error 图标
     */
    var mErrorViewIconRes = -1
    get() {
        if(field == -1){
            return R.mipmap.error
        }
        return field
    }
    private set
    /**
     * error 文本提示
     */
    var mErrorTextRes = -1
    get() {
        if(field == -1){
            return R.string.error_tip
        }
        return field
    }
    private set

    /**
     * loading 资源
     */
    var mLoadingViewRes = -1
    get() {
        if(field == -1){
            return R.layout.default_layout_loading
        }
        return field
    }
    private set
    /**
     * 无网络时图标
     */
    var mNoNetworkViewIconRes = -1
    get() {
        if(field == -1){
            return R.mipmap.no_network
        }
        return field
    }
    private set

    /**
     * 无网络时文字提示
     */
    var mNoNetworkTextRes = -1
    get() {
        if(field == -1){
            return R.string.no_network
        }
        return field
    }
    private set

    fun noNetworkIcon(noNetworkIconRes:Int):AppStatueConfig{
        mNoNetworkViewIconRes = noNetworkIconRes
        return this
    }
    fun noNetworkTip(noNetworkTipRes: Int):AppStatueConfig{
        mNoNetworkTextRes = noNetworkTipRes
        return this
    }

    fun errorIcon(errorIconRes:Int):AppStatueConfig{
        mErrorViewIconRes = errorIconRes
        return this
    }

    fun errorTip(errorTip:Int):AppStatueConfig{
        mErrorTextRes = errorTip
        return this
    }

    fun emptyIcon(emptyIconRes:Int):AppStatueConfig{
        mEmptyViewIconRes = emptyIconRes
        return this
    }
    fun emptyTip(emptyTip:Int):AppStatueConfig{
        mEmptyTextRes = emptyTip
        return this
    }

    fun loadingView(loadingViewLayoutRes:Int):AppStatueConfig{
        mLoadingViewRes = loadingViewLayoutRes
        return this
    }

}