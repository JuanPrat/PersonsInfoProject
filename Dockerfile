# Usar una imagen base de JDK de Amazon Corretto
FROM amazoncorretto:17-alpine-jdk

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado en el contenedor
COPY build/libs/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]