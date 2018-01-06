package site.paranoia.common.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import site.paranoia.common.widget.TitleBar

/**
 * Created by Paranoia on 17-8-31.
 */
abstract class TitleBarFragment : BaseFragment(){

    private var titleBar: TitleBar? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutMain =LinearLayout(mContext)
        layoutMain.orientation=LinearLayout.VERTICAL
        titleBar= TitleBar(mContext)
        layoutMain.addView(titleBar,LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        val layoutContent = inflater.inflate(bindLayout(), layoutMain, false)
        layoutMain.addView(layoutContent, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        return layoutMain
    }


    fun getToolBar() :Toolbar {
        return titleBar!!.getToolBar()
    }
}