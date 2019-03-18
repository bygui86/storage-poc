
# SwissBlock - Storage PoCs

## Subprojects

* [MongoDB](mongodb-service/)
* [Cassandra](cassandra-service/)
* [Couchbase](couchbase-service/)
* [Solr](solr-service/)
* [Redis](redis-service/)

---

## TODOs

* services
	* reactive
* enable auditing
* spring boot admin console
* monitoring metrics
* tracing

---

## Tech stack

* Java JDK 11 (no modules)
* Spring Boot 2.x
* Spring Framework 5.x
* MongoDB
* Cassandra
* Couchbase
* Solr
* Redis
* Jib
* Kaniko
* Kubernetes

---

## Links

### Performance tests
	https://www.javacodegeeks.com/2019/02/microservices-for-java-developers-performance-and-load-testing.html
	http://httpd.apache.org/docs/current/programs/ab.html

### Java benchmarking
	https://openjdk.java.net/projects/code-tools/jmh/
	https://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/

### Kubernetes
	https://itnext.io/kubernetes-network-deep-dive-7492341e0ab5
	https://itnext.io/kubernetes-ingress-controllers-how-to-choose-the-right-one-part-1-41d3554978d2

### Mirroring/Shadowing traffic
	https://www.serverlab.ca/tutorials/linux/web-servers-linux/how-to-mirror-your-traffic-with-nginx/
	https://alex.dzyoba.com/blog/nginx-mirror/
	https://nginx.org/en/docs/http/ngx_http_mirror_module.html
