package com.rabbit.samples.storagepoc.redis.repos;

import com.rabbit.samples.storagepoc.redis.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@Repository
public interface OrderRepo extends CrudRepository<Order, String> {

	Order findByOrderId(final String orderId);

	void deleteByOrderId(final String orderId);

}
