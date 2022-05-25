package com.mrinalgupta.vertx.vertx_starter.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerExample extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(WorkerExample.class);

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new WorkerExample());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    /* executeBLocking() method : Safely execute some blocking code.
    Executes the blocking code in the handler blockingCodeHandler using a thread from the worker pool.
    When the code is complete the handler resultHandler will be called
     with the result on the original context (e.g. on the original event loop of the caller).

         */
    vertx.executeBlocking(
        event -> {
          LOG.debug("Executing on working thread");
          try {
//            executed on worker thread
            Thread.sleep(5000);
            event.complete();
          } catch (InterruptedException e) {
            LOG.error("Failed : ", e);
            event.fail(e);
          }
        }, result -> {
//          executed on event loop thread
          if(result.succeeded()){
            LOG.debug("Blocking call done");
          }else {
            LOG.debug("Blocking call failed due to : ", result.cause());
          }
      });
  }
}
