package com.revolut.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.revolut.accounts.Routes.RouteManager;
import com.revolut.accounts.handlers.AllRequestHandlers;
import com.revolut.service.CustomerService;
import com.revolut.service.CustomerServiceImpl;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GuiceModule extends AbstractModule {

  private static final Logger LOG = LoggerFactory.getLogger(GuiceModule.class);
  private Vertx vertx;

  public GuiceModule(Vertx vertx){
    super();
    this.vertx = vertx;
  }

  @Override
  protected void configure() {

  }

  @Provides
  @Singleton
  protected RouteManager getRouteManager(){

    return new RouteManager();
  }

  @Provides
  @Singleton
  protected AllRequestHandlers getAllRequestHandlers(){

    return new AllRequestHandlers();
  }


  @Provides
  @Named("cs")
  protected CustomerService getCustomerSrvice(){
    return new CustomerServiceImpl();
  }




}