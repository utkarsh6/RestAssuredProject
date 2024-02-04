FROM maven:3.8.4-openjdk-17

COPY src home/RestassuredApiFramework/src

COPY pom.xml home/RestassuredApiFramework/pom.xml
COPY Pet.jpg home/RestassuredApiFramework/Pet.jpg
COPY reports  home/RestassuredApiFramework/reports
COPY logs  home/RestassuredApiFramework/logs
COPY testng.xml home/RestassuredApiFramework/testng.xml

WORKDIR home/RestassuredApiFramework

ENTRYPOINT mvn clean test