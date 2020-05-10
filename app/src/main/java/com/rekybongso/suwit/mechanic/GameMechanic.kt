package com.rekybongso.suwit.mechanic

class GameMechanic{
    private fun isItTie (_playerInput : String, _enemyInput: String) : Boolean {
        return _playerInput == _enemyInput
    }

    private fun checkIsPlayerWin(_playerInput : String, _enemyInput: String) : Boolean {
        return (_playerInput == "gunting" && _enemyInput == "kertas") ||
                (_playerInput == "batu" && _enemyInput == "gunting") ||
                (_playerInput == "kertas" && _enemyInput == "batu")
    }

    fun randomizeEnemyOutput() : String {
        return listOf("GUNTING!!!", "BATU!!!", "KERTAS!!!").shuffled().first()
    }

    fun calculateScore (_lastScore: Int, _addScoreBy: Int) : Int{
        var lastScore = _lastScore

        lastScore += _addScoreBy
        return lastScore
    }

    fun playTheGame(_playerInput : String, _enemyInput: String) : String{
        return if (isItTie(_playerInput, _enemyInput)) {
            "tie"
        } else if (checkIsPlayerWin(_playerInput, _enemyInput)){
            "win"
        } else {
            "lose"
        }
    }
}