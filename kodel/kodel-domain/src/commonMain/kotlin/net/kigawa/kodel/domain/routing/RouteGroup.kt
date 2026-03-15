package net.kigawa.kodel.domain.routing

abstract class RouteGroup<R> {
    var routes: List<R> = emptyList()
        private set

    fun <T: R> route(initRoute: () -> T): T = initRoute()
        .also { routes += it }
}