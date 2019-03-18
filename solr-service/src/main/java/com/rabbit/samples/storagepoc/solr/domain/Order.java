package com.rabbit.samples.storagepoc.solr.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

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
@SolrDocument(collection = "order")
public class Order {

	@Id
	String id;

	@Field("orderId_s")
	// @Indexed(name = "orderId", type = "string", required = true)
	@NotEmpty
	String orderId;

	@Field("assetPair_s")
	// @Indexed(name = "assetPair", type = "string", required = true)
	@NotEmpty
	String assetPair;

	@Field("source_s")
	// @Indexed(name = "source", type = "string", required = true)
	@NotEmpty
	String source;

	// @ChildDocument
	// @Field(child = true)
	@Field("buy_s")
	// @Indexed(name = "buy", type = "string", required = true)
	@NotNull
	OrderType buy;

	@Field("price_f")
	// @Indexed(name = "price", type = "pfloat", required = true)
	float sell_price;

	@Field("quantity_f")
	// @Indexed(name = "quantity", type = "pfloat", required = true)
	float sell_quantity;

	@Field("date_s")
	// @Indexed(name = "date", type = "string", required = true)
	@NotEmpty
	String date;

	@Field("retrievedAt_s")
	// @Indexed(name = "retrievedAt", type = "string", required = true)
	@NotEmpty
	String retrievedAt;

}
