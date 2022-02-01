FROM openjdk:17
EXPOSE 9001
ADD target/YouFitUserManagementService.jar YouFitUserManagementService.jar
ENTRYPOINT ["java", "-jar", "/YouFitUserManagementService.jar"]
