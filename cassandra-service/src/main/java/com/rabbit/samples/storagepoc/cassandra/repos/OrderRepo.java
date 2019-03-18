package com.rabbit.samples.storagepoc.cassandra.repos;

import com.rabbit.samples.storagepoc.cassandra.domain.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 08 Mar 2019
 */
@Repository
public interface OrderRepo extends CassandraRepository<Order, String> {

	Order findByOrderId(final String orderId);

	void deleteByOrderId(final String orderId);

}
