package com.mrinalgupta.vertx.vertx_starter.eventbus.pointopoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    vertx
        .eventBus()
        .<String>consumer(
            Sender.class.getSimpleName(), message -> LOG.debug("Received : {}", message.body()));
  }
}
