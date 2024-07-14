import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public final class RouterConfig {

    public static Router setupRouter(final Vertx vertx) {
        final var router = Router.router(vertx);

        router.route().handler(routingContext -> {
            routingContext.response()
                    .setStatusCode(200);
        });

        return router;
    }
}
