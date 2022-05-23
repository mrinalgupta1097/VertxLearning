package com.mrinalgupta.vertx.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("Start {}", getClass().getSimpleName());
    //    parents are deployed first
    vertx.deployVerticle(new VerticleA());
    vertx.deployVerticle(new VerticleB());
    /*    while deploying multiple instancs do not pass thr verticle object instead pass name
    vertx will create it by itself
    */

    vertx.deployVerticle(
        VerticleN.class.getName(),
        new DeploymentOptions()
            .setInstances(4)
            .setConfig(
                new JsonObject()
                    .put("id", UUID.randomUUID().toString())
                    .put("name", VerticleN.class.getSimpleName())));
    startPromise.complete();
  }
}
