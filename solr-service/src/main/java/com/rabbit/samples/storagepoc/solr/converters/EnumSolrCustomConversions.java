package com.rabbit.samples.storagepoc.solr.converters;

import org.springframework.data.solr.core.convert.SolrCustomConversions;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 18 Mar 2019
 */
public class EnumSolrCustomConversions extends SolrCustomConversions {

	public EnumSolrCustomConversions(final List<?> converters) {

		super(converters);
	}

	@Override
	public boolean isSimpleType(final Class<?> clazz) {
		if (Enum.class.equals(clazz) || Enum.class.isAssignableFrom(clazz)) {
			return false;
		}
		return super.isSimpleType(clazz);
	}

}
