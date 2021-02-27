package org.oriolbellet.football.error

class LineUpException(errorCode: ErrorCode, msg: String): FootballException(errorCode, msg)