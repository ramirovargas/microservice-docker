package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Order;
import com.tanerdiler.microservice.account.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient("containerized-bills")
public interface BillsServiceClient
{
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/products/{productId}")
	Product findById(@PathVariable("productId") Integer orderId);

	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/products")
	List<Product> findAll();

	@RequestMapping(method = RequestMethod.POST, value = "/api/v1/products/save")
	void save(@RequestBody Order order);
}
