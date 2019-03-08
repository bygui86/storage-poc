package com.swissblock.storagepoc.cassandra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.List;


@Configuration
// @EnableCassandraRepositories
@EnableCassandraRepositories(basePackages = "com.swissblock.storagepoc.cassandra.repos")
public class PersistenceConfig extends AbstractCassandraConfiguration {

	String keyspaceName = "orders";

	@Override
	protected String getKeyspaceName() {

		return keyspaceName;
	}

	@Override
	public SchemaAction getSchemaAction() {

		// return SchemaAction.CREATE_IF_NOT_EXISTS;
		return SchemaAction.RECREATE;
	}

	// WARNING: quick patch to avoid NoClassDefFoundError exception of class com.codahale.metrics.JmxReporter
	@Override
	@Bean
	public CassandraClusterFactoryBean cluster() {

		final CassandraClusterFactoryBean cluster = super.cluster();
		cluster.setJmxReportingEnabled(false);
		return cluster;
	}

	// WARNING: quick patch to avoid "Keyspace not found" exception (part 1)
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {

		List<CreateKeyspaceSpecification> createKeyspaceSpecificationList = new ArrayList<>();
		createKeyspaceSpecificationList.add(
				CreateKeyspaceSpecification.createKeyspace(keyspaceName)
		);
		return createKeyspaceSpecificationList;
	}

	// WARNING: quick patch to avoid "Keyspace not found" exception (part 2)
	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {

		List<DropKeyspaceSpecification> dropKeyspaceSpecificationList = new ArrayList<>();
		dropKeyspaceSpecificationList.add(
				DropKeyspaceSpecification.dropKeyspace(keyspaceName)
		);
		return dropKeyspaceSpecificationList;
	}

}
