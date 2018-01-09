package site.paranoia.wanandroidapp.http

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import site.paranoia.wanandroidapp.bean.ArticleBean

interface ApiService {
    @GET("/article/list/1/json")
    fun getArticle():Deferred<ArticleBean>
}