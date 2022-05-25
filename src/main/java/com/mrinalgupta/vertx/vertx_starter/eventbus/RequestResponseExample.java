package com.mrinalgupta.vertx.vertx_starter.eventbus;

import io.vertx.core.Vertx;

public class RequestResponseExample {
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new RequestVerticle());
    vertx.deployVerticle(new ResponseVerticle());
  }
}
