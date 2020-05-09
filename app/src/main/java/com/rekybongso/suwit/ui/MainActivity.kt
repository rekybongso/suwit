package com.rekybongso.suwit.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.rekybongso.suwit.R
import com.rekybongso.suwit.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val tvPoinPlayer : TextView by bind(R.id.tvPoinPlayer)
    private val tvPoinLawan : TextView by bind(R.id.tvPoinLawan)
    private val tvPilihanLawan : TextView by bind(R.id.tvPilihanLawan)
    private val tvPilihanPlayer : TextView by bind(R.id.tvPilihanPlayer)
    private val tvLogs : TextView by bind(R.id.tvLog)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        tvPoinPlayer.text = 0.toString()
        tvPilihanPlayer.text = getString(R.string.menunggu)
        tvPilihanLawan.text = getString(R.string.menunggu)
        tvLogs.text = getString(R.string.log_aktivitas)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        val pilihGunting = getString(R.string.gunting_in_main)
        val pilihBatu = getString(R.string.batu_in_main)
        val pilihKertas = getString(R.string.kertas_in_main)
        val pilihanLawan = acakPilihanLawan()

        when (v.id){
            R.id.btnGunting -> {
                tvPilihanPlayer.text = pilihGunting
                tvPilihanLawan.text = pilihanLawan

                when (apakahSeri(pilihGunting,pilihanLawan)){
                    true -> {
                        tvLogs.text = getString(R.string.seri)
                    }
                    false -> {
                        if (apakahPlayerMenang(pilihGunting, pilihanLawan)){
                            val lastPointPlayer = tvPoinPlayer.text.toString().toInt()
                            val newPoinPlayer = lastPointPlayer + 1

                            tvLogs.text = getString(R.string.menang)
                            tvPoinPlayer.text = newPoinPlayer.toString()

                        } else {
                            val lastPointlawan = tvPoinLawan.text.toString().toInt()
                            val newPoinlawan = lastPointlawan + 1
                            tvLogs.text = getString(R.string.kalah)
                            tvPoinLawan.text = newPoinlawan.toString()
                        }
                    }
                }
            }
            R.id.btnBatu -> {
                tvPilihanPlayer.text = pilihBatu
                tvPilihanLawan.text = pilihanLawan

                when (apakahSeri(pilihBatu, pilihanLawan)) {
                    true -> {
                        tvLogs.text = getString(R.string.seri)
                    }
                    false -> {
                        if (apakahPlayerMenang(pilihBatu, pilihanLawan)) {
                            val lastPointPlayer = tvPoinPlayer.text.toString().toInt()
                            val newPoinPlayer = lastPointPlayer + 1

                            tvLogs.text = getString(R.string.menang)
                            tvPoinPlayer.text = newPoinPlayer.toString()
                        } else {
                            val lastPointlawan = tvPoinLawan.text.toString().toInt()
                            val newPoinlawan = lastPointlawan + 1

                            tvLogs.text = getString(R.string.kalah)
                            tvPoinLawan.text = newPoinlawan.toString()
                        }
                    }
                }
            }
            R.id.btnKertas -> {
                tvPilihanPlayer.text = pilihKertas
                tvPilihanLawan.text = pilihanLawan

                when (apakahSeri(pilihKertas, pilihanLawan)) {
                    true -> {
                        tvLogs.text = getString(R.string.seri)
                    }
                    false -> {
                        if (apakahPlayerMenang(pilihKertas, pilihanLawan)) {
                            val lastPointPlayer = tvPoinPlayer.text.toString().toInt()
                            val newPoinPlayer = lastPointPlayer + 1

                            tvLogs.text = getString(R.string.menang)
                            tvPoinPlayer.text = newPoinPlayer.toString()
                        } else {
                            val lastPointlawan = tvPoinLawan.text.toString().toInt()
                            val newPoinlawan = lastPointlawan + 1

                            tvLogs.text = getString(R.string.kalah)
                            tvPoinLawan.text = newPoinlawan.toString()
                        }
                    }
                }
            }
        }
    }

}
