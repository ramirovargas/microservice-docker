package com.tanerdiler.microservice.account.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanerdiler.microservice.account.model.Product;
import com.tanerdiler.microservice.account.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductResource
{
	@Autowired
	private ProductRepository repository;

	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/{id}")
	public ResponseEntity<Product> get(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@GetMapping("/getTotal/{products}")
	public ResponseEntity<String> get(@PathVariable("products") List<Product> products) throws IOException {
		int total = products.stream().mapToInt(i -> i.getPrice().intValue()).sum();
		return ResponseEntity.ok(String.valueOf(total));
	}

	@GetMapping()
	public ResponseEntity<Collection<Product>> getAll()
	{
		return ResponseEntity.ok(repository.findAll().get());
	}

	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Product product) {
		repository.save(product);
		return new ApiResponse().send(HttpStatus.OK, null);
	}

}
