package site.paranoia.common.utils

import android.widget.ImageView
import android.widget.SeekBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import site.paranoia.common.R

/**
 * Created by Paranoia on 12/24/17.
 */
fun ImageView.url(url: String, holder: Int = R.drawable.ic_holder_11, error: Int = R.drawable.ic_holder_11) {
    val options = RequestOptions
            .placeholderOf(holder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
    Glide.with(this.context)
            .load(url)
            .apply(options)
            .into(this)
}

fun SeekBar.onSeekBarChange(change: ((Int) -> Unit)) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            change.invoke(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    })
}
