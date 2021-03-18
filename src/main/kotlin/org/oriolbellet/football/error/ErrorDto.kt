package org.oriolbellet.football.error

import kotlinx.serialization.Serializable

@Serializable data class ErrorDto(val errorCode: ErrorCode, val message: String)