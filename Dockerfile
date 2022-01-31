FROM openjdk:17
EXPOSE 9001
ADD target/UserManagementService.jar UserManagementService.jar
ENTRYPOINT ["java", "-jar", "/UserManagementService.jar"]
