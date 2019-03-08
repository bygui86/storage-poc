package com.swissblock.storagepoc.cassandra.controllers;


import com.swissblock.storagepoc.cassandra.domain.Order;
import com.swissblock.storagepoc.cassandra.repos.OrderRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@RestController
@RequestMapping(value = "/orders/write")
public class OrderWriteController {

	OrderRepo orderRepo;

	@PostMapping(
			consumes = APPLICATION_JSON_VALUE,
			produces = APPLICATION_JSON_VALUE
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Order insert(
			@RequestBody @Valid final Order order) {

		log.info("insert order: {}", order);

		return save(order);
	}

	// @PutMapping(
	// 		consumes = APPLICATION_JSON_VALUE,
	// 		produces = APPLICATION_JSON_VALUE
	// )
	// public Order update(
	// 		@RequestBody @Valid final Order order) {
	//
	// 	log.info("update order: {}", order);
	//
	// 	return save(order);
	// }

	@DeleteMapping
	public void deleteAll() {

		log.warn("delete all orders");

		getOrderRepo().deleteAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable final String id) {

		log.warn("delete order by id {}", id);

		getOrderRepo().deleteByOrderId(id);
	}

	Order save(final Order order) {

		return getOrderRepo().save(order);
	}

}
