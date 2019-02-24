# Extend vert.x image
FROM vertx/vertx3
ADD target/Leaf-Vertx.jar Leaf-Vertx.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "Leaf-Vertx.jar"]
#
ENV VERTICLE_NAME com.revolut.config.Runner
ENV VERTICLE_FILE target/Leaf-Vertx.jar