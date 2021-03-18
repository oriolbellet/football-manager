package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.Default
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

    constructor(team: Team): this(name = team.name, lineUp = LineUp(tactic = team.lineUp.tactic)) {
        team.squad.forEach {
            val player = Player(it)
            squad.add(player)
            lineUp.addPlayer(player)
        }
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Team

        if (name != other.name) return false
        if (lineUp != other.lineUp) return false
        if (def != other.def) return false
        if (teamId != other.teamId) return false
        if (squad != other.squad) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lineUp.hashCode()
        result = 31 * result + def.hashCode()
        result = 31 * result + (teamId?.hashCode() ?: 0)
        result = 31 * result + squad.hashCode()
        return result
    }

}
