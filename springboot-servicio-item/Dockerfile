FROM openjdk:11

MAINTAINER Ignacio Garay <ignacio_garayll@hotmail.com>

ARG artifact_id
ARG artifact_version

ENV artifact ${artifact_id}-${artifact_version}.jar

# Create app directory
RUN mkdir -p /usr/src/app/${artifact_id}
RUN mkdir -p /data
WORKDIR /usr/src/app/${artifact_id}

# Install app dependencies
COPY target/${artifact} /usr/src/app/${artifact_id}/${artifact}

EXPOSE 8080

CMD exec java -Duser.timezone=America/Lima $JAVA_OPTIONS -jar ${artifact}