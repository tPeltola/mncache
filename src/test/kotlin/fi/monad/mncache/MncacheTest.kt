package fi.monad.mncache
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactor.awaitSingle

@MicronautTest
class MncacheTest(private val f: Flowing): StringSpec({

    "flow with multiple values should be cached" {
        f.flowing(1).toList() shouldBe listOf(1, 2)
    }

    "flux with multiple values should be cached" {
        f.flux(2).collectList().awaitSingle() shouldBe listOf(2, 3)
    }
})
