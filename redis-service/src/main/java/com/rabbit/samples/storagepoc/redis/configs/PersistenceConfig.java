package com.rabbit.samples.storagepoc.redis.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 03 Feb 2019
 */
@Slf4j
@Configuration
// @EnableRedisRepositories(basePackages = "com.rabbit.samples.storagepoc.redis.repos")
public class PersistenceConfig {

	/*
		Define a Jedis connection factory
	 */
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		log.debug("Create JedisConnectionFactory...");

		return new JedisConnectionFactory();
	}

	/*
		Use the Jedis connection factory in the RedisTemplate
	 */
	@Bean
	RedisTemplate<String, Object> redisTemplate() {

		log.debug("Create RedisTemplate...");

		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
