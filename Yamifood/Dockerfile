FROM ubuntu:latest
RUN apt update -y
RUN apt install -y openjdk-8-jdk
RUN mkdir -p /u01/data
COPY target/Yamifood-0.0.1-SNAPSHOT.war /u01/data
RUN chmod -R 777 /u01
ENTRYPOINT ["java","-jar","/u01/data/Yamifood-0.0.1-SNAPSHOT.war"]