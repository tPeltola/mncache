package fi.monad.mncache

import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import reactor.core.publisher.Flux

@Singleton
open class Flowing {
    @Cacheable(cacheNames = ["sample"], parameters = ["first"])
    open fun flowing(first: Int): Flow<Int> = flow {
        emit(first)
        emit(first + 1)
    }

    @Cacheable(cacheNames = ["sample"])
    open fun flux(first: Int): Flux<Int> = Flux.just(first, first + 1)
}