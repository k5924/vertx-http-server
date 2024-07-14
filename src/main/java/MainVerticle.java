import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import routers.GetRouter;
import routers.MainRouter;


public final class MainVerticle extends AbstractVerticle {

    private final int port;

    public MainVerticle(final int port) {
        this.port = port;
    }

    @Override
    public void start(final Promise<Void> startFuture) {
        final var router = new MainRouter().create(vertx);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port, httpServerAsyncResult -> {
                    if (httpServerAsyncResult.succeeded()) {
                        System.out.println("Http server started on port " + port);
                        startFuture.complete();
                    } else {
                        System.err.println("Http server failed to start");
                        startFuture.fail(httpServerAsyncResult.cause());
                    }
                });
    }

    @Override
    public void stop(final Promise<Void> stopFuture) {
        vertx.close(voidAsyncResult -> {
            if (voidAsyncResult.succeeded()) {
                System.out.println("Vertx shut down gracefully");
                stopFuture.complete();
            } else {
                System.err.println("Error during vertx shutdown");
                stopFuture.fail(voidAsyncResult.cause());
            }
        });
    }
}
