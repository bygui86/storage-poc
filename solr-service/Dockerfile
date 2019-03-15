
# Base
FROM openjdk:11-jre-slim

# Labels
LABEL maintainer="MBSolidConsulting"

# Set the SHELL option -o pipefail before RUN with a pipe in
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# Set environment variables
ENV JVM_OPTIMIZATIONS='-noverify -server -XX:TieredStopAtLevel=1'

# Expose ports
EXPOSE 8081 8091

# Set default working directory
WORKDIR /opt

# Change root password
# TODO replace with sudo/su removal
RUN echo "root:cm9vdHNlY3JldA==" | chpasswd

# Change owner of important folders
RUN chown -hR 1001:1002 /opt/

# Run as user different than root
USER 1001

# Copy jar inside image
COPY target/*service.jar /opt/app.jar

# Start application
ENTRYPOINT exec java $JVM_OPTIMIZATIONS -Xms$HEAP_SIZE -Xmx$HEAP_SIZE -XX:MaxMetaspaceSize=$META_SIZE $JAVA_OPTS -jar app.jar
