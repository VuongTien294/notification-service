FROM openjdk:8

COPY target/*.jar notification-service.jar
EXPOSE 8285
ENTRYPOINT ["java","-jar","/notification-service.jar"]