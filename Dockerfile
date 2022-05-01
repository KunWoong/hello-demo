FROM amazoncorretto:17.0.2
WORKDIR application
ARG JAR_FILE=build/libs/hello*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
