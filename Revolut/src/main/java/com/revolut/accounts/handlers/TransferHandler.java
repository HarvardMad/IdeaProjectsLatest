package com.revolut.accounts.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class TransferHandler implements Handler<RoutingContext> {

@Override
public void handle(RoutingContext ctx) {
    String hi = ctx.get("hi");
    if(hi.equals("you're nice")){
    ctx.request().response().end(hi);
    }else{
    ctx.fail(401);
    } }
}
