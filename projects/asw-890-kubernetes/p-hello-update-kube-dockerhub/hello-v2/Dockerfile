############################################
# Dockerfile per l'applicazione hello 
############################################

FROM openjdk:17-jdk 

# RUN apt-get update && apt-get install -y curl

ADD build/libs/hello-2.0.jar hello-2.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "hello-2.0.jar"]
