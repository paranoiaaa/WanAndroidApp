package site.paranoia.wanandroidapp

import android.app.Application
import site.paranoia.common.Common

/**
 * Created by Paranoia on 1/3/18.
 */
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        Common.with(this)
    }
}