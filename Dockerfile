#
## Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
## Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template
#
#FROM alpine:latest
#
#CMD ["/bin/sh"]

FROM amazoncorretto:8-alpine-jdk

COPY target/SpringBoot-0.0.1-SNAPSHOT.jar app.jar   

ENTRYPOINT ["java","-jar","/app.jar"]
