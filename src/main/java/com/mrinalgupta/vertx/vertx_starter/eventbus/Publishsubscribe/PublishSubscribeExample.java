package com.mrinalgupta.vertx.vertx_starter.eventbus.Publishsubscribe;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class PublishSubscribeExample {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new Publish());
    vertx.deployVerticle(new Subscriber1());
    vertx.deployVerticle(new Subscriber2());
    vertx.deployVerticle(Subscriber2.class, new DeploymentOptions().setInstances(2));
  }
}
