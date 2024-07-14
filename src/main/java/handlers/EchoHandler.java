package handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public final class EchoHandler implements Handler<RoutingContext> {
    @Override
    public void handle(final RoutingContext routingContext) {
        final var content = routingContext.pathParam("content");
        routingContext.response()
                .setStatusCode(200)
                .putHeader("Contetnt-Type", "text/plain")
                .putHeader("Content-Length", Integer.toString(content.length()))
                .write(content);
    }
}
