package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Match
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class MatchAdapter(@Inject private val matchDao: MatchDao): SaveMatch, FindMatch {

    override fun save(match: Match): Match {
        return this.matchDao.save(match)
    }

    override fun findMatchById(matchId: Long): Optional<Match> {
        return this.matchDao.findById(matchId)
    }

}