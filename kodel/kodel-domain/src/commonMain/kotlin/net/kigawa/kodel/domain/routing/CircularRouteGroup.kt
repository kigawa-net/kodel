package net.kigawa.kodel.domain.routing

abstract class CircularRouteGroup<R, G: RouteGroup<*>>: RouteGroup<R>() {
    var groups: List<G> = emptyList()
        private set

    fun <T: G> group(initGroup: () -> T): T = initGroup()
        .also { groups += it }

}
