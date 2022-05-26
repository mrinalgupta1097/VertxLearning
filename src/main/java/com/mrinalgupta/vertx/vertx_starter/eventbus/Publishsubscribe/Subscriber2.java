package com.mrinalgupta.vertx.vertx_starter.eventbus.Publishsubscribe;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Subscriber2 extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(Subscriber2.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx
        .eventBus()
        .<String>consumer(
            Publish.class.getName(), message -> LOG.debug("Received2 : {}", message.body()));
  }
}
