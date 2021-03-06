package com.rabbit.samples.storagepoc.redis.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 08 Mar 2019
 */
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RedisHash("orders")
public class Order {

	@Id
	String id;

	@Indexed
	@NotEmpty
	String orderId;

	@NotEmpty
	String assetPair;

	@NotEmpty
	String source;

	// @Reference
	@NotNull
	OrderType buy;

	@NotNull
	OrderType sell;

	@NotEmpty
	String date;

	@NotEmpty
	String retrievedAt;

}
