package com.android.elk.espresso

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher


/**
 * Takes in the id of a drawable and attempts to match it against the view in question
 *
 * @param id
 */
fun withDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {
    override fun describeTo(description: Description) {
        description.appendText("ImageView with drawable same as drawable with id $id")
    }

    override fun matchesSafely(view: View): Boolean {
        val context = view.context
        val expectedBitmap = context.getDrawable(id)?.toBitmap()

        return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
    }
}

fun withDrawable(
    @DrawableRes id: Int,
    @ColorRes tint: Int? = null,
) = object : TypeSafeMatcher<View>() {
    override fun describeTo(description: Description) {
        description.appendText("ImageView with drawable same as drawable with id $id")
        tint?.let { description.appendText(", tint color id: $tint") }
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun matchesSafely(view: View): Boolean {
        val context = view.context
        val expectedBitmap = context.getDrawable(id)?.tinted(tint)?.toBitmap()

        return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
    }

    private fun Drawable.tinted(@ColorInt tintColor: Int? = null) =
        apply {
            setTintList(tintColor?.toColorStateList())
        }

    private fun Int.toColorStateList() = ColorStateList.valueOf(this)
}

/**
 * Apache 2.0
 *
 * @see [Source1](https://github.com/stablekernel/EspressoLib/blob/master/src/main/java/com/stablekernel/espressolib/DrawableMatcher.java)
 *
 * @see [Source2](http://stackoverflow.com/questions/33696488/getting-bitmap-from-vector-drawable)
 */
class DrawableMatcher(@param:DrawableRes private val expectedResourceId: Int) :
    TypeSafeMatcher<View>(View::class.java) {
    override fun matchesSafely(item: View): Boolean {
        if (item !is ImageView) return false
        val imageView = item
        if (expectedResourceId == 0) return imageView.drawable == null
        val expectedDrawable = ContextCompat.getDrawable(
            item.getContext(),
            expectedResourceId
        ) ?: return false
        val actualDrawable = imageView.drawable
        if (expectedDrawable is VectorDrawable) {
            return if (actualDrawable !is VectorDrawable) false else vectorToBitmap(
                expectedDrawable
            ).sameAs(vectorToBitmap(actualDrawable))
        }
        if (expectedDrawable is BitmapDrawable) {
            return if (actualDrawable !is BitmapDrawable) false else expectedDrawable.bitmap.sameAs(
                actualDrawable.bitmap
            )
        }
        throw IllegalArgumentException("Unsupported drawable: " + imageView.drawable)
    }

    override fun describeTo(description: Description) {
        description.appendText("with drawable id: ").appendValue(expectedResourceId)
    }

    companion object {
        private fun vectorToBitmap(vectorDrawable: VectorDrawable): Bitmap {
            val bitmap = Bitmap.createBitmap(
                vectorDrawable.intrinsicWidth,
                vectorDrawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
            vectorDrawable.draw(canvas)
            return bitmap
        }
    }
}