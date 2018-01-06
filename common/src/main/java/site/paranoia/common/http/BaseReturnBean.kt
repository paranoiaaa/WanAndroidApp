package site.paranoia.common.http

/**
 * Created by Paranoia on 12/24/17.
 */
class BaseReturnBean<T>(var statusCode:Int,var statusMsg:String,var result:T)