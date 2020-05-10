package com.rekybongso.suwit.util

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import java.util.*

fun <T : View> Activity.bind(@IdRes res : Int) : Lazy <T> {
            @Suppress("UNCHECKED_CAST")
            return lazy { findViewById<T>(res) }
}

fun transformInput (baseString : String, charToRemove : Char, replaceWith: Char, lowerCased : Boolean) : String {
    if (lowerCased){
        baseString.replace(charToRemove, replaceWith)
    } else {
        baseString.replace(charToRemove, replaceWith).toLowerCase(Locale.ROOT)
    }
    return baseString
}