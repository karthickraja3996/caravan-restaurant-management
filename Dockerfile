FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY menu /app

WORKDIR /app

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/menu-0.0.1-SNAPSHOT.jar"]