package com.rabbit.samples.storagepoc.mongodb.repos;

import com.rabbit.samples.storagepoc.mongodb.domain.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 08 Mar 2019
 */
@Repository
public interface OrderRepo extends MongoRepository<Order, ObjectId> {

	Order findByOrderId(final String orderId);

	void deleteByOrderId(final String orderId);

}
