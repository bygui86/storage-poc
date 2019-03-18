
# Storage PoCs - Redis

## Run

1. Start Redis
	```
	docker run -d --name redis -p 6379:6379 redis:alpine redis-server --appendonly yes
	```

2. Start application
	```
	cd <PROJECT_ROOT_FOLDER>/redis-service
	make clean run
	```

---

## Links

* https://www.baeldung.com/spring-data-redis-tutorial
* https://github.com/spring-projects/spring-data-examples/tree/master/redis/repositories
