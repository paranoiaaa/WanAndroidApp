package site.paranoia.wanandroidapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import pers.victor.ext.inflate
import site.paranoia.wanandroidapp.R

/**
 * Created by paranoia on 2018/1/9.
 */
class ArticleAdapter :RecyclerView.Adapter<ArticleAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder = Holder(inflate(R.layout.item_article,parent, false))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
    }

    override fun getItemCount(): Int =10

    class Holder(override val containerView: View?):RecyclerView.ViewHolder(containerView),LayoutContainer
}