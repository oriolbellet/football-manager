package org.oriolbellet.football.domain.player

import org.oriolbellet.football.domain.team.Team
import javax.persistence.*

@Entity
@Table(name = "PLAYER")
class Player {

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var playerId: String

    @Column
    lateinit var name: String

    @Column
    lateinit var alias: String

    @Column
    var average: Int = 0

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    lateinit var team: Team

}
