package com.geromino_apps.domain.gateway

interface IGateWayArgumented<T, H> {
    fun query(s: H?): T
    fun store(o: T)
}