package com.rekybongso.suwit.util

fun acakPilihanLawan () : String {
    var pilihanLawan = listOf("GUNTING!!!", "BATU!!!", "KERTAS!!!").shuffled().first()
    return  pilihanLawan
}

fun apakahSeri (pilihanPlayer: String, pilihanLawan: String) : Boolean {
    return pilihanPlayer == pilihanLawan
}

fun apakahPlayerMenang (pilihanPlayer : String, pilihanLawan: String) : Boolean{
    var pilihanPlayer = pilihanPlayer.replace("!","").toLowerCase()
    var pilihanLawan = pilihanLawan.replace("!","").toLowerCase()

    return (pilihanPlayer == "batu" && pilihanLawan == "gunting") ||
            (pilihanPlayer == "kertas" && pilihanLawan == "batu") ||
            (pilihanPlayer == "gunting" && pilihanLawan == "kertas")
}
