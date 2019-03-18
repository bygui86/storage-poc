package com.rabbit.samples.storagepoc.mongodb.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "orders")
public class Order {

	@Id
	ObjectId id;

	@Indexed
	@NotEmpty
	String orderId;

	@NotEmpty
	String assetPair;

	@NotEmpty
	String source;

	@NotNull
	OrderType buy;

	@NotNull
	OrderType sell;

	@NotEmpty
	String date;

	@NotEmpty
	String retrievedAt;

}
