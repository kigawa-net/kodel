package net.kigawa.kodel.domain.routing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class CircularRouteGroupTest {
    private class TestRoute()

    private class TestGroupCircular() : CircularRouteGroup<TestRoute, TestGroupCircular>()

    @Test
    fun `routes is empty initially`() {
        val group = TestGroupCircular()
        assertEquals(emptyList(), group.routes)
    }

    @Test
    fun `groups is empty initially`() {
        val group = TestGroupCircular()
        assertEquals(emptyList(), group.groups)
    }

    @Test
    fun `route adds route and returns it`() {
        val group = TestGroupCircular()
        val route = TestRoute()

        val returned = group.route { route }

        assertSame(route, returned)
        assertEquals(listOf(route), group.routes)
    }

    @Test
    fun `route adds multiple routes in order`() {
        val group = TestGroupCircular()
        val r1 = TestRoute()
        val r2 = TestRoute()
        val r3 = TestRoute()

        group.route { r1 }
        group.route { r2 }
        group.route { r3 }

        assertEquals(listOf(r1, r2, r3), group.routes)
    }

    @Test
    fun `group adds subgroup and returns it`() {
        val root = TestGroupCircular()
        val sub = TestGroupCircular()

        val returned = root.group { sub }

        assertSame(sub, returned)
        assertEquals(listOf(sub), root.groups)
    }

    @Test
    fun `group adds multiple subgroups in order`() {
        val root = TestGroupCircular()
        val g1 = TestGroupCircular()
        val g2 = TestGroupCircular()

        root.group { g1 }
        root.group { g2 }

        assertEquals(listOf(g1, g2), root.groups)
    }

    @Test
    fun `routes and groups are independent`() {
        val root = TestGroupCircular()
        val route = TestRoute()
        val sub = TestGroupCircular()

        root.route { route }
        root.group { sub }

        assertEquals(listOf(route), root.routes)
        assertEquals(listOf(sub), root.groups)
    }

    @Test
    fun `subgroup routes do not affect parent routes`() {
        val root = TestGroupCircular()
        val sub = root.group { TestGroupCircular() }
        sub.route { TestRoute() }

        assertEquals(emptyList(), root.routes)
        assertEquals(1, sub.routes.size)
    }
}
