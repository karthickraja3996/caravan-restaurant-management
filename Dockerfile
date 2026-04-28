FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY menu /app

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/menu-0.0.1-SNAPSHOT.jar"]