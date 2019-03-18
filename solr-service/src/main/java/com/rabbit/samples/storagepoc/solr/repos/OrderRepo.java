package com.rabbit.samples.storagepoc.solr.repos;

import com.rabbit.samples.storagepoc.solr.domain.Order;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 08 Mar 2019
 */
@Repository
public interface OrderRepo extends SolrCrudRepository<Order, String> {

	Order findByOrderId(final String orderId);

	void deleteByOrderId(final String orderId);

}
