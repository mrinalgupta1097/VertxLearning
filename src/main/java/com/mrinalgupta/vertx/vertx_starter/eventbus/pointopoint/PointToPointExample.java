package com.mrinalgupta.vertx.vertx_starter.eventbus.pointopoint;

import io.vertx.core.Vertx;

public class PointToPointExample {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new Sender());
    vertx.deployVerticle(new Receiver());
  }
}
