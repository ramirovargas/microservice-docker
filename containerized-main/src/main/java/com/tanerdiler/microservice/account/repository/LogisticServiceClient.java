package com.tanerdiler.microservice.account.repository;

import com.tanerdiler.microservice.account.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient("containerized-logistic")
public interface LogisticServiceClient
{
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/orders/{orderId}")
	Order findById(@PathVariable("orderId") Integer orderId);

	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/orders")
	List<Order> findAll();

	@RequestMapping(method = RequestMethod.POST, value = "/api/v1/orders/save")
	void save(@RequestBody Order order);
}
