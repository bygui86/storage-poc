package com.rabbit.samples.storagepoc.cassandra.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
// import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
// import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotEmpty;


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
@Table("orders")
public class Order {

	// @Id
	// @PrimaryKey
	// At least one PrimaryKeyColumn must be of type PARTITIONED
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	@NotEmpty
	String orderId;

	@NotEmpty
	String assetPair;

	@NotEmpty
	String source;

	float orderBuyPrice;

	float orderBuyQuantity;

	float orderSellPrice;

	float orderSellQuantity;

	@NotEmpty
	String date;

	@NotEmpty
	String retrievedAt;

}
