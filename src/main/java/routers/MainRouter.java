package routers;

import handlers.NotFoundHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;

public final class MainRouter implements IRouter{
    @Override
    public Router create(final Vertx vertx) {
        final var router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route().handler(ResponseTimeHandler.create());
        router.route().handler(LoggerHandler.create());
        router.get().subRouter(new GetRouter().create(vertx));
        router.route().handler(new NotFoundHandler());
        return router;
    }
}
