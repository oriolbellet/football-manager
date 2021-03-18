package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.Default
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_BELONGING
import org.oriolbellet.football.error.LineUpException
import java.util.*

class LineUp(lineUp: List<Player> = emptyList(), var tactic: BasicTactics) {

    private val numGoalkeepers = 1
    private val numPlayersLineUp = 11

    var lineUpId: UUID? = null
    val lineUp: MutableList<Player> = lineUp.toMutableList()

    @Default
    constructor(lineUpId: UUID?, lineUp: List<Player>, tactic: BasicTactics) : this(lineUp, tactic) {
        this.lineUpId = lineUpId
    }

    fun addPlayer(player: Player) {
        lineUp.add(player)
    }

    fun goalKeeper(): Player {
        return lineUp[0]
    }

    fun defenders(): List<Player> {
        val fromIndex = numGoalkeepers
        return lineUp.subList(fromIndex, fromIndex + tactic.getNumDefenders())
    }

    fun midfielders(): List<Player> {
        val fromIndex = numGoalkeepers + tactic.getNumDefenders()
        return lineUp.subList(fromIndex, fromIndex + tactic.getNumMidfielders())
    }

    fun forwards(): List<Player> {
        val fromIndex = numGoalkeepers + tactic.getNumDefenders() + tactic.getNumMidfielders()
        return lineUp.subList(fromIndex, numPlayersLineUp)
    }

    fun getMidfieldPoints(): Int {
        return this.midfielders().stream().mapToInt { x -> x.average }.sum()
    }

    fun getAttackPoints(): Int {
        return this.forwards().stream().mapToInt { x -> x.average }.sum()
    }

    fun getDefensePoints(): Int {
        return this.defenders().stream().mapToInt { x -> x.average }.sum() +
                this.goalKeeper().average
    }

    fun substitution(player1: Player, player2: Player) {

        val player1pos = lineUp.indexOf(player1)
        val player2pos = lineUp.indexOf(player2)

        if (player1pos == -1) {
            throw LineUpException(PLAYER_NOT_BELONGING, "Player ${player1.playerId} not belongs to lineUp $lineUpId")
        }

        if (player2pos == -1) {
            throw LineUpException(PLAYER_NOT_BELONGING, "Player ${player2.playerId} not belongs to lineUp $lineUpId")
        }

        Collections.swap(lineUp, player1pos, player2pos)
    }
}