package org.oriolbellet.football.application.service

import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito

fun <T> any(type: Class<T>): T = Mockito.any(type)

fun <T> any(): T {
    Mockito.any<T>()
    return uninitialized()
}

@Suppress("UNCHECKED_CAST")
fun <T> uninitialized(): T = null as T

fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

fun <T : Any> eq(value: T): T = eq(value) ?: value