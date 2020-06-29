package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Order;
import com.tanerdiler.microservice.account.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository
{
	private final static Map<Integer, Order> orders = new HashMap<>();
	private final static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(1, "Camara", 100d,3));
		products.add(new Product(2, "Tv", 5d,2));
		products.add( new Product(3, "Computador", 200d,2));
		products.add(new Product(4, "Celular", 50d,1));
		orders.put(1, new Order(1,products,1, new Date(),"Calle 123"));
		orders.put(2, new Order(2,products,1, new Date(),"Calle 123"));
		orders.put(3, new Order(3,products,1, new Date(),"Calle 123"));
		orders.put(4, new Order(4,products,1, new Date(),"Calle 123"));
		orders.put(5, new Order(5,products,2, new Date(),"Calle 123"));
		orders.put(6, new Order(6,products,2, new Date(),"Calle 123"));
		orders.put(7, new Order(7,products,2, new Date(),"Calle 123"));
		orders.put(8, new Order(8,products,2, new Date(),"Calle 123"));
		orders.put(9, new Order(9,products,3, new Date(),"Calle 123"));
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
