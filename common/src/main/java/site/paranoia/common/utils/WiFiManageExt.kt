package site.paranoia.common.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager

@SuppressLint("MissingPermission")

fun Activity.isWifiConnected() :Boolean {
    val connectivityManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    return wifiNetworkInfo.isConnected
}

@SuppressLint("ServiceCast", "MissingPermission", "WifiManagerLeak")
fun Activity.wifiEnable (enabled:Boolean) {
    val wifiManager=getSystemService(Context.WIFI_SERVICE) as WifiManager
    if (enabled){
        if (!wifiManager.isWifiEnabled)
            wifiManager.isWifiEnabled = enabled
    }else{
        if (wifiManager.isWifiEnabled)
            wifiManager.isWifiEnabled = enabled
    }
}
