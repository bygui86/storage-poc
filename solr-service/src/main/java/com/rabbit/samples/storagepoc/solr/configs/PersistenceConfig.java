package com.rabbit.samples.storagepoc.solr.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.samples.storagepoc.solr.converters.OrderTypeSolrCustomConversions;
import com.rabbit.samples.storagepoc.solr.converters.StringToOrderTypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.MappingSolrConverter;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.mapping.SolrPersistentEntity;
import org.springframework.data.solr.core.mapping.SolrPersistentProperty;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Configuration
// @EnableSolrRepositories(basePackages = "com.rabbit.samples.storagepoc.solr.repos")
public class PersistenceConfig {

	// no-op

	// @Bean
	// public SolrConverter solrConverter() {
	//
	// 	log.debug("Create SolrJConverter...");
	//
	// 	return new SolrJConverter();
	// }

	@Bean
	public SolrConverter solrConverter(final MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext) {

		log.debug("Create custom SolrConverter...");

		// final EnumToStringConverter enumToStringConverter = new EnumToStringConverter(
		// 		new DefaultConversionService()
		// );
		// final List<Object> enumToStringConverterList = new ArrayList<>();
		// enumToStringConverterList.add(enumToStringConverter);

		final StringToOrderTypeConverter stringToOrderTypeConverter = new StringToOrderTypeConverter(
				new DefaultConversionService(),
				new ObjectMapper()
		);
		final List<Object> stringToOrderTypeConverterList = new ArrayList<>();
		stringToOrderTypeConverterList.add(stringToOrderTypeConverter);

		final MappingSolrConverter converter = new MappingSolrConverter(mappingContext);
		// converter.setCustomConversions(new EnumSolrCustomConversions(enumToStringConverterList));
		converter.setCustomConversions(new OrderTypeSolrCustomConversions(stringToOrderTypeConverterList));
		return converter;
	}

	// @Bean
	// public MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext() {
	//
	// 	log.debug("Create custom Solr MappingContext...");
	//
	// 	final MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext = new SimpleSolrMappingContext();
	// 	return mappingContext;
	// }

	@Bean
	public SolrTemplate solrATemplate(
			final SolrClient solrClient,
			final MappingContext<? extends SolrPersistentEntity<?>, SolrPersistentProperty> mappingContext) {

		log.debug("Create custom SolrTemplate...");

		SolrTemplate solrTemplate = new SolrTemplate(solrClient);
		solrTemplate.setSolrConverter(solrConverter(mappingContext));
		// solrTemplate.setMappingContext(mappingContext());
		return solrTemplate;
	}

}
