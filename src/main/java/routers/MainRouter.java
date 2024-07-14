package routers;

import handlers.NotFoundHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public final class MainRouter implements IRouter{
    @Override
    public Router create(final Vertx vertx) {
        final var router = Router.router(vertx);
        router.get().subRouter(new GetRouter().create(vertx));
        router.route().handler(new NotFoundHandler());
        return router;
    }
}
