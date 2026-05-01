FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY menu /app

WORKDIR /app

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "target/menu-0.0.1-SNAPSHOT.jar"]