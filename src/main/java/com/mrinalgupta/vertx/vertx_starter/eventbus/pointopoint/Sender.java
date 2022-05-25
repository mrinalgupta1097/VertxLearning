package com.mrinalgupta.vertx.vertx_starter.eventbus.pointopoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class Sender extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    //    create a timer for each second
    vertx.setPeriodic(
        1000, id -> vertx.eventBus().send(Sender.class.getSimpleName(), "Sending a message..."));
  }
}
