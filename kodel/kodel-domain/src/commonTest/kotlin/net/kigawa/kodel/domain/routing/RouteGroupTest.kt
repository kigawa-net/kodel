package net.kigawa.kodel.domain.routing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class RouteGroupTest {
    private open class TestRoute()

    private class TestGroup : RouteGroup<TestRoute>()

    @Test
    fun `routes is empty initially`() {
        val group = TestGroup()
        assertEquals(emptyList(), group.routes)
    }

    @Test
    fun `route adds route and returns it`() {
        val group = TestGroup()
        val route = TestRoute()

        val returned = group.route { route }

        assertSame(route, returned)
        assertEquals(listOf(route), group.routes)
    }

    @Test
    fun `route adds multiple routes in order`() {
        val group = TestGroup()
        val r1 = TestRoute()
        val r2 = TestRoute()
        val r3 = TestRoute()

        group.route { r1 }
        group.route { r2 }
        group.route { r3 }

        assertEquals(listOf(r1, r2, r3), group.routes)
    }

    @Test
    fun `route returns subtype`() {
        class SpecialRoute() : TestRoute()

        val group = TestGroup()
        val special = SpecialRoute()

        val returned: SpecialRoute = group.route { special }

        assertSame(special, returned)
    }
}
