package org.oriolbellet.football.domain.player

import org.oriolbellet.football.domain.Default
import org.oriolbellet.football.domain.team.Team
import java.util.*

class Player(val name: String, val alias: String, val average: Int, var team: Team) {

    var playerId: UUID? = null

    @Default
    constructor(playerId: UUID, name: String, alias: String, average: Int, team: Team) : this(
        name,
        alias,
        average,
        team
    ) {
        this.playerId = playerId
    }

    constructor(player: Player) : this(player.name, player.alias, player.average, player.team)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        if (name != other.name) return false
        if (alias != other.alias) return false
        if (average != other.average) return false
        if (playerId != other.playerId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + alias.hashCode()
        result = 31 * result + average
        result = 31 * result + (playerId?.hashCode() ?: 0)
        return result
    }
}
