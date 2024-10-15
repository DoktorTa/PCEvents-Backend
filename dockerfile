FROM openjdk:21-slim
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/pc-event.backend-0.0.1.jar"]
