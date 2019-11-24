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

/**
 * docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' hardcore_boyd
 */

public class CouchBaseVerticle extends AbstractVerticle {

  public static final String COUCHBASEHOST = "172.17.0.2";

  Bucket leafBucket;

  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    //leafBucket = bucket();
  }

  private Cluster cluster() {
    return CouchbaseCluster.create(COUCHBASEHOST);
  }


  private Bucket bucket() {
    return cluster().openBucket("LeafBucket", "leafUser");
  }

  public void start() {
    //System.out.println("couchbase deployed " + leafBucket);
    vertx.eventBus().consumer("couchbaseVertilce", message -> {

      vertx.executeBlocking(fut -> {
        // Invoke blocking code with received message data
        String couchbaseCustomerDocumentId = UUID.randomUUID().toString();
        JsonObject jsonObject = JsonObject.fromJson(message.body().toString());
        JsonDocument doc = JsonDocument.create(couchbaseCustomerDocumentId, jsonObject);
        //leafBucket.upsert(doc);
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
