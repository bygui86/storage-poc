
# SwissBlock - Storage PoCs - MongoDB replica set

## Run

### Locally
```
cd <PROJECT_ROOT_FOLDER>/mongodb-service
docker run -d --rm --name mongo -p 27017:27017 mongo
make clean run
```

---

## Links

* https://www.baeldung.com/spring-data-mongodb-tutorial
* https://hub.docker.com/_/mongo
