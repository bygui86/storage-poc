package com.swissblock.storagepoc.couchbase.configs;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PROTECTED)
// @Configuration
// @EnableCouchbaseRepositories(basePackages={"com.swissblock.storagepoc.couchbase.repos"})
public class PersistenceConfig {
		// extends AbstractCouchbaseConfiguration {

	// @Value("${spring.couchbase.bootstrap-hosts}")
	String[] couchbaseHosts = { "localhost" };

	// @Value("${spring.couchbase.bucket.name}")
	String couchbaseBucketName = "orders";

	// @Value("${spring.couchbase.bucket.password}")
	String couchbaseBucketPassword = "password";

	// @Override
	// protected List<String> getBootstrapHosts() {
	//
	// 	return Arrays.asList(getCouchbaseHosts());
	// }
	//
	// @Override
	// protected String getBucketName() {
	//
	// 	return getCouchbaseBucketName();
	// }
	//
	// @Override
	// protected String getBucketPassword() {
	//
	// 	return getCouchbaseBucketPassword();
	// }

}
