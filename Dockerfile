FROM adoptopenjdk/openjdk15

COPY /build/libs/Spring-MongoDB-0.0.1-SNAPSHOT.jar Spring-MongoDB-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","Spring-MongoDB-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080