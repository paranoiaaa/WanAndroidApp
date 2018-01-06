package site.paranoia.common

import android.annotation.SuppressLint
import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import pers.victor.ext.Ext


@SuppressLint("StaticFieldLeak")
/**
 * Created by Paranoia on 17-8-31.
 */
object Common {
    lateinit var context: Application
    var screenWidth = 0
    var screenHeight = 0
    var screenDensity = 0f
    var scaledDensity = 0f

    fun with(app: Application) {
        context = app
        getDisplayMetrics()
        Ext.with(app)
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(0)
                .methodOffset(7)
                .tag("Common")
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    private fun getDisplayMetrics() {
        val metric = context.resources.displayMetrics
        screenWidth = metric.widthPixels
        screenHeight = metric.heightPixels
        screenDensity = metric.density
        scaledDensity = metric.scaledDensity
    }
}