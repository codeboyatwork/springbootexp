FROM openjdk:11-jdk
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","app.war"]

EXPOSE 2222
EXPOSE 8080