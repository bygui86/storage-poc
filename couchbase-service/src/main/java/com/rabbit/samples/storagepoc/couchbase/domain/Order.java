package com.rabbit.samples.storagepoc.couchbase.domain;

import com.couchbase.client.java.repository.annotation.Field;
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
import org.springframework.data.couchbase.core.mapping.Document;

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
@Document
public class Order {

	@Id
	@Field
	@NotEmpty
	String orderId;

	@Field
	@NotEmpty
	String assetPair;

	@Field
	@NotEmpty
	String source;

	@Field
	@NotNull
	OrderType buy;

	@Field
	@NotNull
	OrderType sell;

	@Field
	@NotEmpty
	String date;

	@Field
	@NotEmpty
	String retrievedAt;

}
