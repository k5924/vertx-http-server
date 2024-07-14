package routers;

import handlers.EchoHandler;
import handlers.OkResponseHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public final class GetRouter implements IRouter {

    @Override
    public Router create(Vertx vertx) {
        final var router = Router.router(vertx);
        router.get("/").handler(new OkResponseHandler());
        router.get("/echo/:content").handler(new EchoHandler());
        return router;
    }
}
