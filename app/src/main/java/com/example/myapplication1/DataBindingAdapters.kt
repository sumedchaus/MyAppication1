package com.example.myapplication1

import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


// used for adding image view to recycler view using data binding
// due to glide we dont need to download the image data repetadly everytime we open the app.
class DataBindingAdapters {
    companion object {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageSource(imageView: ImageView, imageResId: Int) {
            imageView.setImageDrawable(imageView.context.getDrawable(imageResId))
        }

        @JvmStatic
        @BindingAdapter("imgSrc")
        fun setImageResource(imageView: ImageView, imgSrc: Int) {
            val context = imageView.context
            val opts = RequestOptions()
            opts.dontAnimate()
            opts.fallback(imgSrc)

            Glide.with(context).load(null)
                .apply(opts)
                .into(imageView)
        }
    }
}
