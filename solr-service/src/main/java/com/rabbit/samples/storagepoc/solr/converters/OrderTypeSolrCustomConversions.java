package com.rabbit.samples.storagepoc.solr.converters;

import com.rabbit.samples.storagepoc.solr.domain.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.solr.core.convert.SolrCustomConversions;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 18 Mar 2019
 */
@Slf4j
public class OrderTypeSolrCustomConversions extends SolrCustomConversions {

	public OrderTypeSolrCustomConversions(final List<?> converters) {
		super(converters);
	}

	@Override
	public boolean isSimpleType(final Class<?> clazz) {

		log.debug("***** is simple type *****");

		if (OrderType.class.equals(clazz) || OrderType.class.isAssignableFrom(clazz)) {
			return false;
		}

		return super.isSimpleType(clazz);
	}

}
