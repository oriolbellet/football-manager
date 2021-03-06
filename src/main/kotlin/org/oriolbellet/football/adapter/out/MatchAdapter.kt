package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.CycleAvoidingMappingContext
import org.oriolbellet.football.adapter.out.model.MatchMapper
import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Match
import java.util.*
import javax.inject.Named

@Named
class MatchAdapter(
    private val matchDao: MatchDao,
    private val matchMapper: MatchMapper
) : SaveMatch, FindMatch {

    override fun save(match: Match): Match {
        val matchDataEntity = matchMapper.toMatchDataEntity(match, CycleAvoidingMappingContext())
        return matchMapper.toMatch(this.matchDao.save(matchDataEntity), CycleAvoidingMappingContext())
    }

    override fun findMatchById(matchId: Long): Optional<Match> {
        val findById = matchDao.findById(matchId)
        return if (!findById.isPresent) {
            Optional.empty()
        } else {
            Optional.of(matchMapper.toMatch(findById.get(), CycleAvoidingMappingContext()))
        }
    }
}