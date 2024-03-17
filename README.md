# chat-llm-server
Servicio para Chat Interactivo basado en LLM con gRPC

## Preparar entorno Java

```sh
wget https://download.java.net/java/GA/jdk13.0.1/cec27d702aa74d5a8630c65ae61e4305/9/GPL/openjdk-13.0.1_linux-x64_bin.tar.gz
tar -xvf openjdk-13.0.1_linux-x64_bin.tar.gz
mv jdk-13.0.1 /opt/
```

Configurar variables de entorno

```sh
JAVA_HOME='/opt/jdk-13.0.1'
PATH="$JAVA_HOME/bin:$PATH"
export PATH
```

## Preparar entorno local con maven

```sh
wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
tar -xvf apache-maven-3.6.3-bin.tar.gz
mv apache-maven-3.6.3 /opt/
```

Configurar variables de entorno

```sh
M2_HOME='/opt/apache-maven-3.6.3'
PATH="$M2_HOME/bin:$PATH"
export PATH
```

# Ejecutar Servidor gRPC

## Ejecutar con Java (CLI)

```sh
mvn clean package
java -jar target/chat-server-1.0.0.jar
```

## Ejecutar usando Docker

Se debe generar la imagen del contenedor

```sh
docker buildx build . -t xnet/chat-llm-server:0.1.0
```

```sh
docker run --rm \
  --name chat-llm-server \
  -p 8999:8999 \
  xnet/chat-llm-server:0.1.0
```

## Ejecutar con Docker Compose

Se debe crear un archivo `.env` y colocar los siguientes parametros previo a la ejecución del docker compose:

|Parametro|Valoe|
|-|-|
|API_KEY|Valor del APIKEY obtenido de OpenAI|

```sh
docker compose up -d
```

# References

1. [Chat con embeding desde documentos](https://github.com/langchain4j/langchain4j-examples/blob/main/other-examples/src/main/java/ChatWithDocumentsExamples.java)

> Autor: Ilver Anache <ianache@crossnetcorp.com>
