
# SwissBlock - Storage PoCs - Solr

## Run

1. Start Solr
	```
	docker run -d --name solr -p 8983:8983 -t solr:alpine
	docker exec -it --user=solr solr bin/solr create_core -c order
	```

2. Start application
	```
	cd <PROJECT_ROOT_FOLDER>/solr-service
	make clean run
	```

---

## Links

* https://www.baeldung.com/spring-data-solr
* https://hub.docker.com/_/solr
* https://github.com/dtrunk90/gs-nested-solr-documents
* https://docs.spring.io/spring-data/solr/docs/current/reference/html/

### collaterals

* https://medium.com/@pablocastelnovo/nesting-documents-in-apache-solr-12ef44ea2901

### issues

* https://stackoverflow.com/questions/37241489/solrj-6-0-0-insertion-of-a-bean-object-which-associate-list-of-bean-object-is-g/37243756#37243756
* https://stackoverflow.com/questions/39785462/nested-documents-with-spring-data-solr
* https://jira.spring.io/browse/DATASOLR-444

### TO READ
https://github.com/dtrunk90/gs-nested-solr-documents
http://lifelongprogrammer.blogspot.com/2017/03/making-child-documents-working-with-spring-data-solr.html?m=1
http://lucene.apache.org/solr/guide/6_6/transforming-and-indexing-custom-json.html
https://stackoverflow.com/questions/36848536/spring-data-solr-advanced-nested-model-use-case
