package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.player.Player
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "TEAM")
class Team {

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var teamId: String

    @Column
    lateinit var name: String

    @OneToMany(mappedBy = "team")
    lateinit var squad: MutableList<Player>

    @OneToOne
    lateinit var lineUp: LineUp

    fun addPlayer(player: Player) {
        if (!this.squad.contains(player)) {
            this.squad.add(player)
        }
    }

}
