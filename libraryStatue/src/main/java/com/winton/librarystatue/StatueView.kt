package com.winton.librarystatue

import android.content.Context
import android.support.v4.view.LayoutInflaterCompat
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * @author: winton
 * @time: 2018/9/29 下午4:00
 * @desc: Statue实现类
 */
class StatueView : RelativeLayout,IStatueView{

    private  var mEmptyView: View? = null

    private  var mErrorView: View? = null

    private  var mLoadingView: View? = null

    private  var mNoNetworkView: View? = null

    private  var mContentView: View? = null

    private var mStatus = IStatueView.STATUS_CONTENT

    var mListener:IStatueListener? = null

    private val viewParams:LayoutParams by lazy {
        LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
    }

    var mContentViewId = -1

    var mEmptyViewIconRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mEmptyViewIconRes}else{field}

    var mEmptyTextRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mEmptyTextRes}else{field}

    var mErrorViewIconRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mErrorViewIconRes}else{field}

    var mErrorTextRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mErrorTextRes}else{field}

    var mLoadingViewRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mLoadingViewRes}else{field}

    var mNoNetworkViewIconRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mNoNetworkViewIconRes}else{field}

    var mNoNetworkTextRes = -1
    get() = if(field == -1){StatusViewFactory.appConfig().mNoNetworkTextRes}else{field}


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    /**
     * 根据资源获取View
     */
    private fun getView(resId:Int):View?{
        return LayoutInflater.from(context).inflate(resId,null)
    }

    /**
     * 视图加载完毕时，默认显示内容
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        showContent()
    }

    private fun showViewByStatus(status:Int){
        mEmptyView?.visibility = if(status == IStatueView.STATUS_EMPTY){ View.VISIBLE}else{View.GONE}
        mNoNetworkView?.visibility = if(status == IStatueView.STATUS_NO_NETWOEK){View.VISIBLE}else{View.GONE}
        mErrorView?.visibility = if(status == IStatueView.STATUS_ERROR){View.VISIBLE}else{View.GONE}
        mContentView?.visibility = if(status == IStatueView.STATUS_CONTENT){View.VISIBLE}else{View.GONE}
        mLoadingView?.visibility = if(status == IStatueView.STATUS_LOADING){View.VISIBLE}else{View.GONE}
    }

    override fun showLoading() {
        mStatus = IStatueView.STATUS_LOADING
        if(mLoadingView == null){
            mLoadingView = getView(mLoadingViewRes)
            addView(mLoadingView,0,viewParams)
        }
        showViewByStatus(mStatus)
    }

    override fun showError() {
        mStatus = IStatueView.STATUS_ERROR
        if(mErrorView == null){
            mErrorView = getView(R.layout.common_view)
            addView(mErrorView,0,viewParams)
            findViewById<ImageView>(R.id.iv_icon).setImageResource(mErrorViewIconRes)
            findViewById<TextView>(R.id.tv_tip).setText(mErrorTextRes)
            mErrorView?.setOnClickListener {
                mListener?.onRetry()
            }
        }
        showViewByStatus(mStatus)
    }

    override fun showEmpty() {
        mStatus = IStatueView.STATUS_EMPTY
        if(mEmptyView == null){
            mEmptyView = getView(R.layout.common_view)
            addView(mEmptyView,0,viewParams)
            findViewById<ImageView>(R.id.iv_icon).setImageResource(mEmptyViewIconRes)
            findViewById<TextView>(R.id.tv_tip).setText(mEmptyTextRes)
            mEmptyView?.setOnClickListener{
                mListener?.onRetry()
            }
        }
        showViewByStatus(mStatus)
    }

    override fun showContent() {
        mStatus = IStatueView.STATUS_CONTENT
        if(mContentView == null){
            if(mContentViewId != -1){
                mContentView = getView(mContentViewId)
                addView(mContentView,0,layoutParams)
            }else{
                if(childCount > 0){
                    mContentView = getChildAt(childCount-1)
                }else{
                    Log.d("easyStatue","no contentView")
                }
            }
        }
        showViewByStatus(mStatus)
    }

    override fun showNoNetwork() {
        mStatus = IStatueView.STATUS_NO_NETWOEK
        if(mNoNetworkView == null){
            mNoNetworkView = getView(mStatus)
            addView(mNoNetworkView,0,viewParams)
            findViewById<ImageView>(R.id.iv_icon).setImageResource(mNoNetworkViewIconRes)
            findViewById<TextView>(R.id.tv_tip).setText(mNoNetworkTextRes)
            mNoNetworkView?.setOnClickListener{
                mListener?.onRetry()
            }
        }
        showViewByStatus(mStatus)
    }

}