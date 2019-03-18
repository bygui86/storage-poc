package com.rabbit.samples.storagepoc.couchbase.configs;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.package.name:com.rabbit.samples}")
	String swaggerPackageName;

	/**
	 * Swagger API documentation setup
	 *
	 * @return {@link Docket}
	 */
	@Bean
	public Docket api() {

		log.debug("Loading SWAGGER configurations: package {}", getSwaggerPackageName());

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(
						basePackage(getSwaggerPackageName())
				)
				.paths(
						PathSelectors.any()
				)
				.build();
	}

}
