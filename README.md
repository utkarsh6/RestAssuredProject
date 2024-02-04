The framework contains the following feature:
1. Proper package with industry standard naming convention
2. Proper Logging
3. Report
4. Data driven test case 

In this framework we have also  dockerized the framework 
Steps are :
Create a Dockerfile 
write the below command 
FROM maven:3.8.4-openjdk-17

COPY src home/RestassuredApiFramework/src


COPY pom.xml home/RestassuredApiFramework/pom.xml
COPY Pet.jpg home/RestassuredApiFramework/Pet.jpg
COPY reports  home/RestassuredApiFramework/reports
COPY logs  home/RestassuredApiFramework/logs
COPY testng.xml home/RestassuredApiFramework/testng.xml

WORKDIR home/RestassuredApiFramework

ENTRYPOINT mvn clean test

Go to command line and navigate to the project location
Run the below command 

docker build -t restassuredframewok:1 .

 docker run restassuredframewok


