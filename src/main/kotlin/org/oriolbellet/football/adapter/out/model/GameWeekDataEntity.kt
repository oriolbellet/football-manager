package org.oriolbellet.football.adapter.out.model

import javax.persistence.*

@Entity
@Table(name = "GAME_WEEK")
data class GameWeekDataEntity(

    @Id
    @Column(name = "GAME_WEEK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val gameWeekId: Long,

    @OneToMany(cascade = [CascadeType.ALL])
    val matches: List<MatchDataEntity>)