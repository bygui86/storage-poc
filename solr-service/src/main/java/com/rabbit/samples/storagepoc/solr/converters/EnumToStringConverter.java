package com.rabbit.samples.storagepoc.solr.converters;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ClassUtils;


/**
 * Copied from Spring org.springframework.core.convert.support.EnumToStringConverter
 *
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 18 Mar 2019
 */
public final class EnumToStringConverter implements Converter<Enum<?>, String>, ConditionalConverter {

	private final ConversionService conversionService;

	public EnumToStringConverter(final ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@SuppressWarnings("rawtypes")
	public boolean matches(final TypeDescriptor sourceType, final TypeDescriptor targetType) {

		for (final Class interfaceType : ClassUtils.getAllInterfacesForClass(sourceType.getType())) {
			if (conversionService.canConvert(TypeDescriptor.valueOf(interfaceType), targetType)) {
				return false;
			}
		}
		return true;
	}

	public String convert(final Enum<?> source) {
		return source.name();
	}

}
