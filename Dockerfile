# Define a imagem do Amazon Corretto visto que a OpenJDK está depreciada
FROM amazoncorretto:17

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o .JAR do projeto gerado pelo Spring Boot para o container
COPY /client-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta de comunicação
EXPOSE 8080

# Inicia a aplicação no container
CMD ["java", "-jar", "app.jar"]

# Comandos para execução via terminal
# docker build -t velociapptor .
# docker run -p 8080:8080 velociapptor
