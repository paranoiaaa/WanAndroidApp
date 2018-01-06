package site.paranoia.common.http

/**
 * Created by Paranoia on 12/24/17.
 */
data class BrowseListReturnBean(var hasmore: Boolean,
                      var page_total: Int,
                      var goodsbrowse_list: List<GoodsbrowseList>) {
        data class GoodsbrowseList(var goods_id: String,
                                   var goods_name: String,
                                   var goods_promotion_price: String,
                                   var goods_promotion_type: String,
                                   var goods_marketprice: String,
                                   var goods_image: String,
                                   var store_id: String,
                                   var gc_id: String,
                                   var gc_id_1: String,
                                   var gc_id_2: String,
                                   var gc_id_3: String,
                                   var browsetime: String,
                                   var goods_image_url: String,
                                   var browsetime_day: String,
                                   var browsetime_text: String)
}