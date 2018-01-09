package site.paranoia.wanandroidapp.fragment

import com.orhanobut.logger.Logger
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import site.paranoia.common.base.BaseFragment
import site.paranoia.wanandroidapp.R
import site.paranoia.wanandroidapp.http.Api


/**
 * Created by Paranoia on 1/4/18.
 */
class HomeFragment : BaseFragment() {

    override fun bindLayout(): Int = R.layout.fragment_home

    override fun initWidget() {

    }

    override fun setListener() {

    }

    override fun loadData() {
        async(UI) {
            try {
                val articleList = Api.retrofitApiService.getArticle()
                Logger.d(articleList.await().errorCode)
                articleList.await()
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}