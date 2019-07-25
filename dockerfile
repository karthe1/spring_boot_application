#
# Package stage
#
FROM openjdk:8-jre-slim
VOLUME /tmp
COPY target/demo1-0.0.1-SNAPSHOT.war demo1.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo1.war"]