package com.rekybongso.suwit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.rekybongso.suwit.R
import com.rekybongso.suwit.util.ExtraFun
import com.rekybongso.suwit.util.bind
import com.rekybongso.suwit.mechanic.GameMechanic

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val extraFun = ExtraFun()
    private val gameMechanic = GameMechanic()

    private val tvPlayerPoint : TextView by bind(R.id.textViewPlayerPoint)
    private val tvEnemyPoint : TextView by bind(R.id.textViewEnemyPoint)
    private val tvPlayerInput : TextView by bind(R.id.textViewPlayerChoice)
    private val tvEnemyInput : TextView by bind(R.id.textViewEnemyChoice)
    private val tvInfoLogs : TextView by bind(R.id.textViewLogs)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
    }

    override fun onClick(v: View) {
        val playerLastPoint = tvPlayerPoint.text.toString()
        val enemyLastPoint = tvEnemyPoint.text.toString()

        val showPlayerScore = gameMechanic.calculateScore(playerLastPoint.toInt(), 1)
        val showEnemyScore = gameMechanic.calculateScore(enemyLastPoint.toInt(), 1)

        val enemyInput = extraFun.transformInput(gameMechanic.randomizeEnemyOutput())

        when (v.id){
            R.id.buttonGunting -> {
                val playerInput = extraFun.transformInput(getString(R.string.gunting))

                tvEnemyInput.text = enemyInput
                tvPlayerInput.text = playerInput

                when (gameMechanic.playTheGame(playerInput, enemyInput)){
                    "tie" -> {tvInfoLogs.text = getString(R.string.seri)}
                    "win" -> {
                        tvInfoLogs.text = getString(R.string.menang)
                        tvPlayerPoint.text = showPlayerScore.toString()
                    }
                    "lose" -> {
                        tvInfoLogs.text = getString(R.string.kalah)
                        tvEnemyPoint.text = showEnemyScore.toString()
                    }

                }
            }
            R.id.buttonBatu -> {
                val playerInput = extraFun.transformInput(getString(R.string.batu))

                tvEnemyInput.text = enemyInput
                tvPlayerInput.text = playerInput

                when (gameMechanic.playTheGame(playerInput, enemyInput)){
                    "tie" -> {tvInfoLogs.text = getString(R.string.seri)}
                    "win" -> {
                        tvInfoLogs.text = getString(R.string.menang)
                        tvPlayerPoint.text = showPlayerScore.toString()
                    }
                    "lose" -> {
                        tvInfoLogs.text = getString(R.string.kalah)
                        tvEnemyPoint.text = showEnemyScore.toString()
                    }

                }
            }
            R.id.buttonKertas -> {
                val playerInput = extraFun.transformInput(getString(R.string.kertas))

                tvEnemyInput.text = enemyInput
                tvPlayerInput.text = playerInput

                when (gameMechanic.playTheGame(playerInput, enemyInput)){
                    "tie" -> {tvInfoLogs.text = getString(R.string.seri)}
                    "win" -> {
                        tvInfoLogs.text = getString(R.string.menang)
                        tvPlayerPoint.text = showPlayerScore.toString()
                    }
                    "lose" -> {
                        tvInfoLogs.text = getString(R.string.kalah)
                        tvEnemyPoint.text = showEnemyScore.toString()
                    }

                }
            }
        }
    }

}
