package site.paranoia.common.widget

import android.app.Activity
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.loading_dialog_layout.view.*
import pers.victor.ext.inflate
import site.paranoia.common.R

/**
* Created by Paranoia on 17-8-31.
*/
class LoadingDialog(activity: Activity) : AlertDialog(activity, R.style.LoadingDialog) {
    private val customView by lazy {
        inflate(R.layout.loading_dialog_layout)
    }

    init {
        setView(customView)
        ownerActivity = activity
    }

    fun show(message: String? = "加载中…") {
        customView.tv_loading_dialog_title.text = message
        super.show()
        val lp = window.attributes
        lp.dimAmount = 0f
        onWindowAttributesChanged(lp)
    }

    fun setText (message: String? = "加载中…") {
        customView.tv_loading_dialog_title.text = message
    }

    override fun dismiss() {
        if (ownerActivity != null && !ownerActivity.isDestroyed) {
            super.dismiss()
        }
    }
}