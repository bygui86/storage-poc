package com.rabbit.samples.storagepoc.couchbase.repos;

import com.rabbit.samples.storagepoc.couchbase.domain.Order;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 08 Mar 2019
 */
// @Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "order")
public interface OrderRepo extends CouchbasePagingAndSortingRepository<Order, String> {

	Order findByOrderId(final String orderId);

	void deleteByOrderId(final String orderId);

}
