package io.quarkus.code.rest

import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes

@ApplicationScoped
class DownloadRerouteFilter {

    fun init(@Observes router: Router) {
        router.route(HttpMethod.GET,"/d").handler {
            it.reroute(it.request().uri().replace("/d", "/api/download"))
        }
    }

}