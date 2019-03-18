package com.rabbit.samples.storagepoc.cassandra.configs;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PROTECTED)
@Configuration
// WARNING: we need to specify a basePackage because config class and repos are not in the same package
@EnableCassandraRepositories(basePackages = "com.rabbit.samples.storagepoc.cassandra.repos")
public class PersistenceConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	String cassandraKeyspaceName;

	@Value("${spring.data.cassandra.schema-action}:create_if_not_exists")
	SchemaAction cassandraSchemaAction;

	@Value("${cassandra.entity.base.packages:com.rabbit.samples.storagepoc.cassandra.domain}")
	String[] cassandraEntityBasePackages;

	@Value("${spring.data.cassandra.jmx-enabled:false}")
	boolean cassandraJmxEnabled;

	@Override
	protected String getKeyspaceName() {

		log.debug("Cassandra keyspace name: {}", getCassandraKeyspaceName());

		return getCassandraKeyspaceName();
	}

	@Override
	public SchemaAction getSchemaAction() {

		log.debug("Cassandra schema action: {}", getCassandraSchemaAction());

		return getCassandraSchemaAction();
	}

	@Override
	public String[] getEntityBasePackages() {

		log.debug("Cassandra entity base packages: {}", Arrays.toString(getCassandraEntityBasePackages()));

		return getCassandraEntityBasePackages();
	}

	// WARNING: quick patch to avoid NoClassDefFoundError exception of class com.codahale.metrics.JmxReporter
	@Override
	@Bean
	public CassandraClusterFactoryBean cluster() {

		log.debug("Cassandra JMX enabled: {}", isCassandraJmxEnabled());

		final CassandraClusterFactoryBean cluster = super.cluster();
		cluster.setJmxReportingEnabled(isCassandraJmxEnabled());
		return cluster;
	}

	// WARNING: quick patch to avoid "Keyspace not found" exception (part 1)
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {

		log.debug("Cassandra keyspace to create: {}", getCassandraKeyspaceName());

		List<CreateKeyspaceSpecification> createKeyspaceSpecificationList = new ArrayList<>();
		createKeyspaceSpecificationList.add(
				CreateKeyspaceSpecification.createKeyspace(getCassandraKeyspaceName())
		);
		return createKeyspaceSpecificationList;
	}

	// WARNING: quick patch to avoid "Keyspace not found" exception (part 2)
	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {

		log.debug("Cassandra keyspace to drop: {}", getCassandraKeyspaceName());

		List<DropKeyspaceSpecification> dropKeyspaceSpecificationList = new ArrayList<>();
		dropKeyspaceSpecificationList.add(
				DropKeyspaceSpecification.dropKeyspace(getCassandraKeyspaceName())
		);
		return dropKeyspaceSpecificationList;
	}

}
