package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository
{
	private final static Map<Integer, Order> orders = new HashMap<>();
	private final static List<Integer> intArray = new ArrayList<>();

	static {
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);
		intArray.add(4);
		orders.put(1, new Order(1,intArray,1, new Date(),"Calle 123"));
		orders.put(2, new Order(2,intArray,1, new Date(),"Calle 123"));
		orders.put(3, new Order(3,intArray,1, new Date(),"Calle 123"));
		orders.put(4, new Order(4,intArray,1, new Date(),"Calle 123"));
		orders.put(5, new Order(5,intArray,2, new Date(),"Calle 123"));
		orders.put(6, new Order(6,intArray,2, new Date(),"Calle 123"));
		orders.put(7, new Order(7,intArray,2, new Date(),"Calle 123"));
		orders.put(8, new Order(8,intArray,2, new Date(),"Calle 123"));
		orders.put(9, new Order(9,intArray,3, new Date(),"Calle 123"));
	}

	public Optional<Order> findById(Integer id)
	{
		return Optional.ofNullable(orders.get(id));
	}

	public Optional<Collection<Order>> findAll()
	{
		return Optional.ofNullable(orders.values());
	}

	public Order save(Order order)
	{
		Integer maxId = orders.keySet().stream().max(Integer::compareTo).get();
		return orders.put(maxId, order);
	}
}
