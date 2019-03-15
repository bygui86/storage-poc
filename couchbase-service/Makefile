
# VARIABLES

# # general
BUILD_TOOL := ./mvnw
NAME := couchbase-service
JAR_FILE := $(shell find target -name '*.jar' 2>/dev/null)
PROTOCOL := http
PORT := 9083
METRICS_PORT := 9093
HEAP_SIZE := 256m
META_SIZE := 300m

# # docker
DOCKER_IMAGE_NAME := storage-poc/$(NAME)
DOCKER_IMAGE_TAG := 0.0.1
DOCKER_IMAGE_PORT := $(PORT)
DOCKER_IMAGE_METRICS_PORT := $(METRICS_PORT)
DOCKER_IMAGE_PORTS := -p $(DOCKER_IMAGE_PORT)\:$(DOCKER_IMAGE_PORT) -p $(DOCKER_IMAGE_METRICS_PORT)\:$(DOCKER_IMAGE_METRICS_PORT)
DOCKER_HOST_NAME := dockerhost
# # retrieving docker IP address on localhost
DOCKER_HOST_IP := $(shell ifconfig en0 | grep inet | grep -v inet6 | awk '{print $$2}')
DOCKER_HOST_LOCAL_BRIDGE := --net bridge --add-host=$(DOCKER_HOST_NAME)\:$(DOCKER_HOST_IP)
DOCKER_ENVVARS := -e HEAP_SIZE=$(HEAP_SIZE) -e META_SIZE=$(META_SIZE)

# # jvm
MEM_OPTS := -Xms$(HEAP_SIZE) -Xmx$(HEAP_SIZE) -XX:MaxMetaspaceSize=$(META_SIZE)
OTHER_OPTS := 

# # makefile
.PHONY: help
.DEFAULT_GOAL := help


# FUNCTIONS

# # building

dependencies :		## Show dependency tree
	$(BUILD_TOOL) dependency:tree -Dverbose

clean :		## Clean the application
	$(BUILD_TOOL) clean

compile :		## Compile the application
	$(BUILD_TOOL) compile

fast-package :		## Build the application package including unit tests only
	$(BUILD_TOOL) -DskipTests package

package : clean		## Build the application package including unit tests only
	$(BUILD_TOOL) package

fast-install :		## Build the application package including all tests and push to artifact repo
	$(BUILD_TOOL) -DskipTests install

install : clean		## Build the application package including all tests and push to artifact repo
	$(BUILD_TOOL) install

test : clean		## Run all tests
	$(BUILD_TOOL) test

# # running

run :		## Run the application through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS)'

java-run :		## Run the application through the generated fat-jar
	java $(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS) -jar $(JAR_FILE)

open :		## Open the browser to the application site
	open $(PROTOCOL)://localhost:$(PORT)

open-metrics :		## Open the browser to the application metrics page
	open $(PROTOCOL)://localhost:$(METRICS_PORT)/actuator

# # docker

docker-prepare :		## Prepare the application to be containerised
	make clean fast-package

docker-build :		## Build the docker image of the application
	docker build -f Dockerfile -t $(DOCKER_IMAGE_NAME):$(DOCKER_IMAGE_TAG) .

docker-run :		## Run the containerised application through docker
	@echo Docker host [$(DOCKER_HOST_NAME)] ip [$(DOCKER_HOST_IP)]
	docker run --rm -it --name $(NAME) $(DOCKER_ENVVARS) $(DOCKER_IMAGE_PORTS) $(DOCKER_HOST_LOCAL_BRIDGE) $(DOCKER_IMAGE_NAME):$(DOCKER_IMAGE_TAG)

docker-run-deamon :		## Run the containerised application as deamon through docker
	@echo Docker host [$(DOCKER_HOST_NAME)] ip [$(DOCKER_HOST_IP)]
	docker run --rm -d --name $(NAME) $(DOCKER_ENVVARS) $(DOCKER_IMAGE_PORTS) $(DOCKER_HOST_LOCAL_BRIDGE) $(DOCKER_IMAGE_NAME):$(DOCKER_IMAGE_TAG)

docker-stop :		## Stop the containerised application
	docker container stop $(NAME)

docker-kill :		## Kill the containerised application
	docker container kill $(NAME)

docker-delete-local : docker-kill		## Delete the docker image of the application
	docker container rm -f $(NAME)
	docker image rm -f $(NAME)

# # general

help :		## Help
	@echo ""
	@echo "*** $(NAME) Makefile help ***"
	@echo ""
	@echo "Targets list:"
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort -k 1,1 | awk 'BEGIN {FS = ":.*?## "}; {printf "\t\033[36m%-30s\033[0m %s\n", $$1, $$2}'
	@echo ""



# LINKS

# Makefile manual	https://www.gnu.org/software/make/manual/make.html
# JVM arguments		https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/maven-plugin/run-mojo.html#jvmArguments
