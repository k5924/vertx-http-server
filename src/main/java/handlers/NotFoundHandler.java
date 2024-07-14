package handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public final class NotFoundHandler implements Handler<RoutingContext> {
    @Override
    public void handle(final RoutingContext routingContext) {
        routingContext.response()
                .setStatusCode(404)
                .end();
    }
}
