FROM maven:3.6.3-openjdk-11 as BUILD
ADD repository.tar.gz /usr/share/maven/ref/

# Copy all project sources to app directory
COPY . /usr/src/app
# Set the working directory to /usr/src/app
WORKDIR /usr/src/app
# Package the project
RUN mvn -s /usr/share/maven/ref/settings-docker.xml package

# Starting from jre8 to build our onw in second step
FROM openjdk:11-jre
# Optional, expose the container port
EXPOSE 8080
# From fist step, copy build jar file to target directory
COPY --from=BUILD /usr/src/app/target/*.jar /opt/target/app.jar
# Set the working directory to /opt/target
WORKDIR /opt/target

# Run the application
ENTRYPOINT ["java","-jar", "app.jar"]