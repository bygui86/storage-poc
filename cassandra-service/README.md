
# SwissBlock - Storage PoCs - Cassandra

## Run

### Locally
```
cd <PROJECT_ROOT_FOLDER>/cassandra-service
docker run -d --rm --name cassandra -p 7199:7199 -p 7000:7000 -p 7001:7001 -p 9160:9160 -p 9042:9042 cassandra
docker run -ti --rm --name cassandra -p 7199:7199 -p 7000:7000 -p 7001:7001 -p 9160:9160 -p 9042:9042 cassandra
make clean run
```

---

## Links

* https://www.baeldung.com/spring-data-cassandra-tutorial
* https://www.baeldung.com/spring-data-cassandratemplate-cqltemplate
* https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#_introduction
* https://hub.docker.com/_/cassandra
* https://medium.com/@michaeljpr/five-minute-guide-getting-started-with-cassandra-on-docker-4ef69c710d84
* https://stackoverflow.com/questions/2359159/cassandra-port-usage-how-are-the-ports-used
* https://github.com/spring-projects/spring-data-examples/tree/master/cassandra
