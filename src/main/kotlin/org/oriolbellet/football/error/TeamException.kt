package org.oriolbellet.football.error

class TeamException(errorCode: ErrorCode, msg: String): FootballException(errorCode, msg)