package com.swissblock.storagepoc.solr.configs;

import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.convert.SolrJConverter;
import org.springframework.data.solr.core.mapping.SimpleSolrMappingContext;
import org.springframework.data.solr.core.mapping.SolrPersistentEntity;
import org.springframework.data.solr.core.mapping.SolrPersistentProperty;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;


@Slf4j
@Configuration
// @EnableSolrRepositories(basePackages = "com.swissblock.storagepoc.solr.repos")
public class PersistenceConfig {

	// no-op

	@Bean
	public SolrConverter solrJConverter() {

		log.debug("Loading SolrJConverter");

		return new SolrJConverter();
	}

	@Bean
	public MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext() {

		log.debug("Loading custom mappingContext");

		final MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext = new SimpleSolrMappingContext();
		return mappingContext;
	}

	@Bean
	public SolrTemplate solrATemplate(SolrClient solrClient) {

		log.info("Loading custom SolrTemplate");

		SolrTemplate solrTemplate = new SolrTemplate(solrClient);
		solrTemplate.setSolrConverter(solrJConverter());
		solrTemplate.setMappingContext(mappingContext());
		return solrTemplate;
	}

}
