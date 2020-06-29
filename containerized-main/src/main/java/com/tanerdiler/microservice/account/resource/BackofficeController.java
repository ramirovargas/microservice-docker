package com.tanerdiler.microservice.account.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanerdiler.microservice.account.dto.OrderDTO;
import com.tanerdiler.microservice.account.model.Account;
import com.tanerdiler.microservice.account.model.Order;
import com.tanerdiler.microservice.account.model.Product;
import com.tanerdiler.microservice.account.repository.AccountServiceClient;
import com.tanerdiler.microservice.account.repository.LogisticServiceClient;
import com.tanerdiler.microservice.account.repository.BillsServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/backoffice")
public class BackofficeController
{
	@Autowired
	private BillsServiceClient billService;
	@Autowired
	private LogisticServiceClient logisticService;
	@Autowired
	private AccountServiceClient accountService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> getOrders()
	{
		List<Order> orders = logisticService.findAll();
		Map<Integer, Account> accounts = new HashMap<>();

		orders.stream()
				.filter(o->!accounts.containsKey(o.getAccountId()))
				.map(o->accountService.findById(o.getAccountId()))
				.forEach(a->accounts.put(a.getId(), a));


		List<OrderDTO> orderDTOList = new ArrayList<>();

		orders.forEach(o->{
			orderDTOList.add(new OrderDTO(
					o.getId(),
					o.getDate(),
					o.getDirection(),
					accounts.get(o.getAccountId()).getFullname(),
					o.getProducts()
			));
		});


		return ResponseEntity.ok(orderDTOList);

	}
	@PostMapping("/checkout")
	public ResponseEntity<String> save(@RequestBody Order order) throws JsonProcessingException {
		logisticService.save(order);
		List<Product> products=order.getProducts();
		String result=objectMapper.writeValueAsString(products);
		String total= billService.getTotal(result);
		return ResponseEntity.ok("Total de su orden: " + total);
	}

}



