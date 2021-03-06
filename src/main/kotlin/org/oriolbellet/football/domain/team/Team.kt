package org.oriolbellet.football.domain.team

import org.oriolbellet.football.adapter.out.model.Default
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.TeamException
import java.util.*

class Team(val name: String, squad: List<Player> = emptyList(), val lineUp: LineUp, val def: Boolean = false) {

    var teamId: UUID? = null
    val squad: MutableList<Player> = squad.toMutableList()

    @Default
    constructor(teamId: UUID?, name: String, squad: List<Player>, lineUp: LineUp, def: Boolean) : this(name, squad.toMutableList(), lineUp, def) {
        this.teamId = teamId
    }

    fun contractPlayer(player: Player) {
        squad.add(player)
        lineUp.addPlayer(player)
    }

    fun changeTactic(tactic: BasicTactics) {
        lineUp.tactic = tactic
    }

    fun substitution(player1: Player, player2: Player) {

        if (!squad.contains(player1)) {
            throw TeamException(ErrorCode.PLAYER_NOT_BELONGING, "Player ${player1.playerId} doesn't belong to team $teamId")
        }

        if(!squad.contains(player2)) {
            throw TeamException(ErrorCode.PLAYER_NOT_BELONGING, "Player ${player2.playerId} doesn't belong to team $teamId")
        }

        lineUp.substitution(player1, player2)
    }
}
