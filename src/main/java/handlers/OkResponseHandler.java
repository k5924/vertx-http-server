package handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public final class OkResponseHandler implements Handler<RoutingContext> {
    @Override
    public void handle(final RoutingContext routingContext) {
        routingContext.response()
                .setStatusCode(200)
                .end();
    }
}
