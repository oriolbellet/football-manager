package org.oriolbellet.football.adapter.out.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "GAME")
data class GameDataEntity(

    @Id
    @Column(name = "GAME_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val gameId: UUID?,

    @OneToMany(cascade = [CascadeType.ALL])
    val gameTeams: List<TeamDataEntity>,

    @OneToOne(cascade = [CascadeType.ALL])
    val userTeam: TeamDataEntity,

    @OneToOne(cascade = [CascadeType.ALL])
    val season: SeasonDataEntity
)