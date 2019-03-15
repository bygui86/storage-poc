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
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


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
// @SolrDocument
// @SolrDocument(collection = "order_type")
public class OrderType {

	// @Id
	// @Field("id_s")
	// String id;

	// @Field("price_f")
	// @Indexed(name = "price_f")
	// @Indexed(name = "price_f", type = "pfloat", required = true)
	float price;

	// @Field("quantity_f")
	// @Indexed(name = "quantity_f")
	// @Indexed(name = "quantity_f", type = "pfloat", required = true)
	float quantity;

}
