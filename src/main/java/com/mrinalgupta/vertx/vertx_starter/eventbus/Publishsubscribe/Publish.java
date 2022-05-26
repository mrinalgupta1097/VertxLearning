package com.mrinalgupta.vertx.vertx_starter.eventbus.Publishsubscribe;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import java.time.Duration;

public class Publish extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    vertx.setPeriodic(
        Duration.ofSeconds(3).toMillis(),
        id -> vertx.eventBus().publish(Publish.class.getName(), "A message for everyone!"));
  }
}
