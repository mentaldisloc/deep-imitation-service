FROM openjdk:17
RUN adduser --disabled-password --gecos "" --no-create-home appuser
WORKDIR /app
COPY target/deep-imitation-service-0.0.1-SNAPSHOT.jar /app/app.jar
RUN chown -R appuser:appuser /app && \
    chmod 500 /app/app.jar \
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]