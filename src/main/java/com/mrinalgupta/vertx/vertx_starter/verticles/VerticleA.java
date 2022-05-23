package com.mrinalgupta.vertx.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleA extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("Start : " + getClass().getSimpleName());
    vertx.deployVerticle(new VerticleAA());
    vertx.deployVerticle(new VerticleAB());
    startPromise.complete();
  }
}
