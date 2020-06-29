package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository
{
	private final static Map<Integer, Product> products = new HashMap<>();

	static {
		products.put(1, new Product(1, "Camara", 100d,3));
		products.put(2, new Product(2, "Tv", 5d,2));
		products.put(3, new Product(3, "Computador", 200d,2));
		products.put(4, new Product(4, "Celular", 50d,1));
	}

	public Optional<Product> findById(Integer id)
	{
		return Optional.ofNullable(products.get(id));
	}

	public Optional<Collection<Product>> findAll() {
		return Optional.ofNullable(products.values());
	}

	public void save(Product p){
		int id=products.get(-1).getId();
		products.put(id+1,p); }
}
