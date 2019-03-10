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
@EnableCassandraRepositories(basePackages = "com.swissblock.storagepoc.cassandra.repos")
public class PersistenceConfig extends AbstractCassandraConfiguration {

	private static final String ORDERS_KEYSPACE = "ordersKeyspace";

	@Override
	protected String getKeyspaceName() {

		return ORDERS_KEYSPACE;
	}

	@Override
	public SchemaAction getSchemaAction() {

		// return SchemaAction.CREATE_IF_NOT_EXISTS;
		return SchemaAction.RECREATE;
	}

	@Override
	public String[] getEntityBasePackages() {

		return new String[]{ "com.swissblock.storagepoc.cassandra.domain" };
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
				CreateKeyspaceSpecification.createKeyspace(ORDERS_KEYSPACE)
		);
		return createKeyspaceSpecificationList;
	}

	// WARNING: quick patch to avoid "Keyspace not found" exception (part 2)
	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {

		List<DropKeyspaceSpecification> dropKeyspaceSpecificationList = new ArrayList<>();
		dropKeyspaceSpecificationList.add(
				DropKeyspaceSpecification.dropKeyspace(ORDERS_KEYSPACE)
		);
		return dropKeyspaceSpecificationList;
	}

}
