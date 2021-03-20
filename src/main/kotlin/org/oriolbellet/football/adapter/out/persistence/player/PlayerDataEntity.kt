package org.oriolbellet.football.adapter.out.persistence.player

import org.oriolbellet.football.adapter.out.persistence.team.TeamDataEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PLAYER")
data class PlayerDataEntity(

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val playerId: UUID?,

    @Column
    val name: String,

    @Column
    val alias: String,

    @Column
    val average: Int,

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    val team: TeamDataEntity
) {

    override fun toString(): String {
        return "PlayerDTO(playerId=$playerId, team=${team.teamId})"
    }
}

