package com.swissblock.storagepoc.solr.domain;

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
import org.springframework.data.solr.core.mapping.ChildDocument;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


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
	@Indexed(name = "orderId_s")
	// @Indexed(name = "orderId_s", type = "string", required = true)
	@NotEmpty
	String orderId;

	@Field("assetPair_s")
	// @Indexed(name = "assetPair_s")
	// @Indexed(name = "assetPair_s", type = "string", required = true)
	@NotEmpty
	String assetPair;

	@Field("source_s")
	// @Indexed(name = "source_s")
	// @Indexed(name = "source_s", type = "string", required = true)
	@NotEmpty
	String source;

	// @Field(child = true)
	// @ChildDocument
	// @NotNull
	// OrderType buy;

	// @ChildDocument
	// @Indexed(name = "buys")
	// @NotNull
	// List<OrderType> buys;

	@Field("buy_s")
	// @Indexed(name = "buy_s")
	// @ChildDocument
	// @NotNull
	OrderType buy;

	// @NotNull
	// OrderType sell;

	@Field("date_s")
	// @Indexed(name = "date_s")
	// @Indexed(name = "date_s", type = "string", required = true)
	@NotEmpty
	String date;

	@Field("retrievedAt_s")
	// @Indexed(name = "retrievedAt_s")
	// @Indexed(name = "retrievedAt_s", type = "string", required = true)
	@NotEmpty
	String retrievedAt;

}
