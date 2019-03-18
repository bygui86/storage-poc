package com.rabbit.samples.storagepoc.solr.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.samples.storagepoc.solr.domain.OrderType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ClassUtils;

import java.io.IOException;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 18 Mar 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter(AccessLevel.PROTECTED)
public final class StringToOrderTypeConverter implements Converter<String, OrderType>, ConditionalConverter {

	ConversionService conversionService;
	ObjectMapper objectMapper;

	public StringToOrderTypeConverter(final ConversionService conversionService, final ObjectMapper objectMapper) {
		this.conversionService = conversionService;
		this.objectMapper = objectMapper;
	}

	@SuppressWarnings("rawtypes")
	public boolean matches(final TypeDescriptor sourceType, final TypeDescriptor targetType) {

		log.debug("***** matching *****");

		for (final Class interfaceType : ClassUtils.getAllInterfacesForClass(sourceType.getType())) {
			if (getConversionService().canConvert(TypeDescriptor.valueOf(interfaceType), targetType)) {
				return false;
			}
		}

		return true;
	}

	public OrderType convert(final String source) {

		log.debug("***** converting *****");

		try {
			return getObjectMapper().readValue(source, OrderType.class);
		} catch (IOException e) {
			log.error("Exception occurred converting string to OrderType: {}", e.getMessage());
		}

		return OrderType.builder().build();
	}

}
