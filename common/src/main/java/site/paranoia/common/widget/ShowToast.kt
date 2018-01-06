package site.paranoia.common.widget

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import pers.victor.ext.dp2px
import pers.victor.ext.findColor
import site.paranoia.common.Common
import site.paranoia.common.R


@SuppressLint("StaticFieldLeak")
object ShowToast {
    private var toast: Toast? = null
    private lateinit var tvText: TextView

    fun shortToast(text: Any?) = showToast(text, Toast.LENGTH_SHORT)

    fun longToast(text: Any?) = showToast(text, Toast.LENGTH_LONG)

    private fun showToast(text: Any?, duration: Int) {
        if (toast == null) {
            tvText = TextView(Common.context)
            tvText.alpha = 0.95f
            tvText.setTextColor(findColor(R.color.text_white))
            tvText.textSize = 14f
            tvText.setBackgroundResource(R.drawable.bg_black_corner_5_trans)
            tvText.setPadding(dp2px(20f), dp2px(10f), dp2px(20f), dp2px(10f))
            tvText.text = text.toString()
            toast = Toast.makeText(Common.context, text.toString(), duration)
            toast?.setGravity(Gravity.BOTTOM, 0, dp2px(120f))
            toast?.view = tvText
        } else {
            tvText.text = text.toString()
        }
        toast?.show()
    }
}
