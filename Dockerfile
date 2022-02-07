FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} YouFitUserManagementService.jar
ENTRYPOINT ["java", "-jar", "/YouFitUserManagementService.jar"]
EXPOSE 9001
