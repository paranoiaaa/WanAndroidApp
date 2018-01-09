package site.paranoia.common.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.jaeger.library.StatusBarUtil
import site.paranoia.common.widget.LoadingDialog
import pers.victor.ext.ActivityMgr
import pers.victor.ext.findColor
import site.paranoia.common.R


/**
* Created by Paranoia on 17-8-30.
*/
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loadingDialog: LoadingDialog
    private var lastClickTime = 0L
    private var exitTime = 0L
    private var doubleBackFinish =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (allowFullScreen()){
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        setContentView(bindLayout())
        StatusBarUtil.setColor(this, findColor(R.color.colorPrimary))
        window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        ActivityMgr.add(this)
        loadingDialog = LoadingDialog(this)
        initData()
        initWidget()
        initInject()
        setListener()
    }

    fun showLoadingDialog(message: String? = "加载中…",cancelable :Boolean =false) {
        if (loadingDialog.isShowing) {
            loadingDialog.setText(message)
        }
        loadingDialog.setCancelable(cancelable)
        loadingDialog.setCanceledOnTouchOutside(cancelable)
        loadingDialog.show(message)
    }

    fun dismissLoadingDialog() {
        loadingDialog.dismiss()
    }

    protected open fun initData() {}

    abstract fun initWidget()

    open fun initInject() {}

    open fun onWidgetsClick(v: View) {}

    abstract fun bindLayout(): Int

    protected fun click(vararg views: View) = views.forEach { it.setOnClickListener(this) }

    override fun onClick(view: View) {
        if (System.currentTimeMillis() - lastClickTime > 300) {
            lastClickTime = System.currentTimeMillis()
            onWidgetsClick(view)
        }
    }

    protected open fun setListener() {

    }

    protected open fun loadData() {

    }

    protected open fun allowFullScreen() = false

    override fun onDestroy() {
        ActivityMgr.remove(this)
        super.onDestroy()
    }


}