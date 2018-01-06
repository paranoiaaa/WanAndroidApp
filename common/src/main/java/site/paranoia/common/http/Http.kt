package site.paranoia.common.http

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by Paranoia on 12/24/17.
 */
class Http<T> {
    lateinit var observable: Observable<BaseReturnBean<T>>
    var success: ((json: BaseReturnBean<T>) -> Unit)? = null
    var fail: ((msg:String) -> Unit)? =null
}

fun <T> http(create: Http<T>.() -> Unit) {
    val h = Http<T>().apply { create() }
    httpPost(h)
}

private class CommonFilter<T> : Function<BaseReturnBean<T>, BaseReturnBean<T>> {
    @Throws(Exception::class)
    override fun apply(t: BaseReturnBean<T>): BaseReturnBean<T> {
        try {
            if (200 != t.statusCode) {
                throw HttpRuntimeException(t.statusMsg)
            }
        }catch (e:Exception) {

        }
        return t
    }
}

@SuppressLint("CheckResult")
fun <T> httpPost(http: Http<T>)  {
    http.observable
            .map(CommonFilter())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                http.success!!.invoke(data)
            }, { throwable ->
                try {
                    throwable.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                    http.fail!!.invoke(e.message!!)
                }
            })
}


