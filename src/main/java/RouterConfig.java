import handlers.NotFoundHandler;
import handlers.OkResponseHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public final class RouterConfig {

    public static Router setupRouter(final Vertx vertx) {
        final var router = Router.router(vertx);
        router.get("/").handler(new OkResponseHandler());
        router.route().handler(new NotFoundHandler());
        return router;
    }
}
