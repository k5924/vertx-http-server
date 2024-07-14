package routers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public interface IRouter {

    Router create(final Vertx vertx);
}
