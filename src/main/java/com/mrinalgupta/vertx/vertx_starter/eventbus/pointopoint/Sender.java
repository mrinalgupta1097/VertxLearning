package com.mrinalgupta.vertx.vertx_starter.eventbus.pointopoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class Sender extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    //    create a timer for each second

    /*
    vertx.setPeriodic() :
      Set a periodic timer to fire every delay milliseconds, at which point handler will be called with the id of the timer.
      Parameters:
        delay - the delay in milliseconds, after which the timer will fire
        handler - the handler that will be called with the timer ID when the timer fires
     */
    vertx.setPeriodic(
        1000, id -> vertx.eventBus().send(Sender.class.getSimpleName(), "Sending a message..."));
  }
}
