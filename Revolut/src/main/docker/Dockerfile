# Extend vert.x image
FROM vertx/vertx3
ADD target/Leaf-Vertx.jar Leaf-Vertx.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "Leaf-Vertx.jar"]
