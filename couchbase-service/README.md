
# SwissBlock - Storage PoCs - Couchbase

## Run

1. Start Couchbase
	1. Run docker container
		```
		docker run -d --name couchbase -p 8091-8094:8091-8094 -p 11210:11210 couchbase
			alternative
		docker run -d --name couchbase -p 8091-8096:8091-8096 -p 11207:11207 -p 11210:11210 -p 11211:11211 -p 18091-18096:18091-18096 couchbase
		```
	2. Access Couchbase UI at http://localhost:8091
	3. Setup Couchbase following the wizard
	4. create a new bucket (must correspond to the value of property `spring.couchbase.bucket.name`)
	5. create a new user
		* username same as bucket name
		* password (must correspond to the value of property `spring.couchbase.bucket.password`)
		* roles (at least): 
			* Bucket Admin
			* Query Select
			* Query Update
			* Query Insert
			* Query Delete
			* Query Manage Index

2. Start application
	```
	cd <PROJECT_ROOT_FOLDER>/couchbase-service
	make clean run
	```

---

## Links

* https://www.baeldung.com/spring-data-couchbase
* https://hub.docker.com/_/couchbase
* https://blog.couchbase.com/couchbase-spring-boot-spring-data/
* https://www.baeldung.com/entity-validation-locking-and-query-consistency-in-spring-data-couchbase
* https://www.baeldung.com/spring-data-couchbase-buckets-and-spatial-view-queries
* https://docs.couchbase.com/server/6.0/learn/security/authorization-overview.html

### issues

* https://stackoverflow.com/questions/51496589/bucket-password-in-couchbase
