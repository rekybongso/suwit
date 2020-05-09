@file:Suppress("NAME_SHADOWING")

package com.rekybongso.suwit.util

import java.util.*

fun acakPilihanLawan () : String {
    return listOf("GUNTING!!!", "BATU!!!", "KERTAS!!!").shuffled().first()
}

fun apakahSeri (pilihanPlayer: String, pilihanLawan: String) : Boolean {
    return pilihanPlayer == pilihanLawan
}

fun apakahPlayerMenang (pilihanPlayer : String, pilihanLawan: String) : Boolean{
    val pilihanPlayer = pilihanPlayer.replace("!", "").toLowerCase(Locale.ROOT)
    val pilihanLawan = pilihanLawan.replace("!","").toLowerCase(Locale.ROOT)

    return (pilihanPlayer == "batu" && pilihanLawan == "gunting") ||
            (pilihanPlayer == "kertas" && pilihanLawan == "batu") ||
            (pilihanPlayer == "gunting" && pilihanLawan == "kertas")
}
