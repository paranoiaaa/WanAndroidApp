package site.paranoia.common.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Paranoia on 17-8-30.
 */
abstract class BaseFragment : Fragment() ,View.OnClickListener{
    protected lateinit var mContext: BaseActivity
    private var lastClickTime = 0L

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(bindLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initWidget()
        loadData()
        setListener()
    }

    abstract fun bindLayout(): Int

    open fun initData() {

    }

    open fun initWidget() {

    }

    open fun loadData() {

    }

    open fun setListener() {

    }

    open fun onWidgetsClick(v: View) {}

    override fun onClick(view: View) {
        if (System.currentTimeMillis() - lastClickTime > 300) {
            lastClickTime = System.currentTimeMillis()
            onWidgetsClick(view)
        }
    }

    protected fun click(vararg views: View) = views.forEach { it.setOnClickListener(this) }

}