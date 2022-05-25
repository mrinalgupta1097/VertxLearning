package com.mrinalgupta.vertx.vertx_starter.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RequestVerticle extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(RequestVerticle.class);
  static final String MY_REQUEST_ADDRESS = "my.request.address";

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    //      there is only one eventBus available per vertx instance.
    EventBus eventBus = vertx.eventBus();
    String message = "Hello World!";
    LOG.debug("Sending : {}", message);
    eventBus.request(
        MY_REQUEST_ADDRESS, message, reply -> LOG.debug("Response : {}", reply.result().body()));
  }
}
