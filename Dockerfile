FROM maven:3.9.6-eclipse-temurin-17

# Crear carpeta de trabajo
WORKDIR /workspace

# Copiar solo los archivos necesarios primero para cache de dependencias
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copiar el resto del proyecto
COPY . .

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Comando por defecto para desarrollo
CMD ["./mvnw", "spring-boot:run"]
