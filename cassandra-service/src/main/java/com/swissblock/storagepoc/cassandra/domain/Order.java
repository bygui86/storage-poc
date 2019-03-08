package com.swissblock.storagepoc.cassandra.domain;

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
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

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
@Table("orders")
public class Order {

	// At least one PrimaryKeyColumn must be of type PARTITIONED
	// @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	@Id
	@NotEmpty
	String orderId;

	// @Column
	@NotEmpty
	String assetPair;

	// @Column
	@NotEmpty
	String source;

	// @Column
	@NotNull
	OrderType buy;

	// @Column
	@NotNull
	OrderType sell;

	// @Column
	@NotEmpty
	String date;

	// @Column
	@NotEmpty
	String retrievedAt;

}
