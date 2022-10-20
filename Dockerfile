FROM openjdk:8
EXPOSE 8088
ADD target/aadhaar-0.0.1-SNAPSHOT.war aadhaar-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/aadhaar-0.0.1-SNAPSHOT.war" ]
