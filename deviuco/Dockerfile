# Usa una imagen base de OpenJDK para ejecutar el proyecto
FROM openjdk:23

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo .jar de tu proyecto al contenedor Docker
COPY target/deviuco-usuarios-0.0.1-SNAPSHOT.jar /app/deviuco-usuarios.jar

# Expone el puerto en el que corre tu aplicación
EXPOSE 8443

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/deviuco-usuarios.jar"]
