package site.paranoia.common.http

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Paranoia on 12/24/17.
 */
interface ApiService {
    @POST("/uramall/mobile/index.php?act=member_goodsbrowse&op=browse_list&page=2&curpage=1")
    fun getHomePage(@Body body: Map<String, String>): Observable<BaseReturnBean<BrowseListReturnBean>>
}