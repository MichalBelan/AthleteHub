#FROM maven:3.9.6-eclipse-temurin-21 as builder
#
#
#WORKDIR /application
#
#COPY pom.xml .
#
## TODO: ak nedefinujes child module build nezbehne:
## 14.15 [ERROR] [ERROR] Some problems were encountered while processing the POMs:
## 14.15 [ERROR] Child module /application/domain of /application/pom.xml does not exist @
#COPY domain domain
#COPY outbound-repository-jpa outbound-repository-jpa
#COPY inbound-controller-ws inbound-controller-ws
#COPY springboot springboot
#COPY api-spec api-spec
#
#RUN mvn package
#RUN mkdir build && cd build && java -Djarmode=layertools -jar ../springboot/target/*.jar extract
#
#FROM eclipse-temurin:21.0.1_12-jdk-alpine
#WORKDIR /application
#
## TODO: na --from=builder pls review
#COPY --from=builder application/build/dependencies/ ./
#COPY --from=builder application/build/spring-boot-loader/ ./
#COPY --from=builder application/build/snapshot-dependencies/ ./
#COPY --from=builder application/build/application/ ./
#
#RUN addgroup -S boot && adduser -S boot -G boot
#USER boot
#
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} org.springframework.boot.loader.launch.JarLauncher"]


# ----------- BUILD STAGE ------------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /application

# Kopíruj root POM a moduly
COPY pom.xml .
COPY domain domain
COPY outbound-repository-jpa outbound-repository-jpa
COPY inbound-controller-ws inbound-controller-ws
COPY springboot springboot
COPY api-spec api-spec

# Build bez testov (odporúčané pre CI)
RUN mvn clean package -DskipTests

# Vytiahni vrstvy pomocou layertools
RUN mkdir build
WORKDIR /application/build
RUN java -Djarmode=layertools -jar ../springboot/target/*.jar extract

# ----------- RUNTIME STAGE ----------
FROM eclipse-temurin:21.0.1_12-jdk-alpine

WORKDIR /application

COPY --from=builder /application/build/dependencies/ ./
COPY --from=builder /application/build/spring-boot-loader/ ./
COPY --from=builder /application/build/snapshot-dependencies/ ./
COPY --from=builder /application/build/application/ ./

# Bezpečnostný užívateľ
RUN addgroup -S boot && adduser -S boot -G boot
USER boot

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} org.springframework.boot.loader.launch.JarLauncher"]
