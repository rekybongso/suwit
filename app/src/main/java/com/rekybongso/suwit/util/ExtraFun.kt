package com.rekybongso.suwit.util

import java.util.*

class ExtraFun {
    fun transformInput (baseString : String) : String {
        return baseString.replace("!", "").toLowerCase(Locale.ROOT)
    }
}