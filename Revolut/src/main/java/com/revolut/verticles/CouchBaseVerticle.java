package com.revolut.verticles;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import java.util.UUID;

public class CouchBaseVerticle extends AbstractVerticle {

  public static final String LOCALHOST = "localhost";

  Bucket leafBucket;

  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    leafBucket = bucket();
  }

  private Cluster cluster() {
    return CouchbaseCluster.create(LOCALHOST);
  }


  private Bucket bucket() {
    return cluster().openBucket("LeafBucket", "LeafUser");
  }

  public void start() {
    System.out.println("couchbase deployed " + leafBucket);
    vertx.eventBus().consumer("couchbaseVertilce", message -> {

      vertx.executeBlocking(fut -> {
        // Invoke blocking code with received message data
        String couchbaseCustomerDocumentId = UUID.randomUUID().toString();
        JsonObject jsonObject = JsonObject.fromJson(message.body().toString());
        JsonDocument doc = JsonDocument.create(couchbaseCustomerDocumentId, jsonObject);
        leafBucket.upsert(doc);
      }, resultHandler -> {
        if (resultHandler.succeeded()) {
          System.out.println((resultHandler.result()).toString());
          vertx.eventBus().send("couchbaseVertilce", (JsonObject) message.body());
        } else {
          System.out.println("persisting customer failed");
        }


      });
    });
  }


}
