package com.swissblock.storagepoc.mongodb.controllers;


import com.swissblock.storagepoc.mongodb.domain.Order;
import com.swissblock.storagepoc.mongodb.repos.OrderRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@RestController
@RequestMapping("/orders/read")
public class OrderReadController {

	OrderRepo orderRepo;

	@GetMapping
	public List<Order> getAll() {

		log.info("get all orders");

		return getOrderRepo().findAll();
	}

	@GetMapping("/{id}")
	public Order getById(@PathVariable final String id) {

		log.info("get order by id {}", id);

		return getOrderRepo().findByOrderId(id);
	}

}
