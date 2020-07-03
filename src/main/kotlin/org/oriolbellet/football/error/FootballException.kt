package org.oriolbellet.football.error

abstract class FootballException(val errorCode: ErrorCode, msg: String): Exception(msg) {
}