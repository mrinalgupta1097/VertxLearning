package com.mrinalgupta.vertx.vertx_starter.eventbus.Publishsubscribe;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Subscriber1 extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(Subscriber1.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx
        .eventBus()
        .<String>consumer(
            Publish.class.getName(), message -> LOG.debug("Received1 : {}", message.body()));
  }
}
