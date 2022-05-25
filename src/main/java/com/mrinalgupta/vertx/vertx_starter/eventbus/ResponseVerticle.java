package com.mrinalgupta.vertx.vertx_starter.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ResponseVerticle extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(ResponseVerticle.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    vertx
        .eventBus()
        .consumer(
            RequestVerticle.MY_REQUEST_ADDRESS,
            message -> {
              LOG.debug("Received Message : {}", message.body());
              message.reply("Received your message. Thanks!");
            });
  }
}
