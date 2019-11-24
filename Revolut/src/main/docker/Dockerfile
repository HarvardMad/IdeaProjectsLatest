FROM java:8-jre
ENV VERTICLE_FILE leaf-1.0-SNAPSHOT-fat.jar

# Set the location of the verticles in Docker
ENV VERTICLE_HOME /usr/verticles

#ADD target/leaf-1.0-SNAPSHOT-fat.jar leaf-vertx.jar
EXPOSE 8091 8092 8093 8094 8095 8096 11210 11211 11213 9119 9998


# Copy your fat jar to the container
COPY target/$VERTICLE_FILE $VERTICLE_HOME/

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $VERTICLE_FILE"]
#ENTRYPOINT ["java", "-jar", "leaf-Vertx.jar"]
#
