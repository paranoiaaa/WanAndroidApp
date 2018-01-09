package site.paranoia.wanandroidapp.http

import site.paranoia.common.http.RetrofitHelper

class Api {
    companion object {
        val retrofitApiService :ApiService by lazy { RetrofitHelper.create("http://www.wanandroid.com").create(ApiService::class.java) }
    }
}