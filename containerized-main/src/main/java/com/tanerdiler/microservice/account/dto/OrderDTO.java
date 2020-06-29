package com.tanerdiler.microservice.account.dto;

import com.tanerdiler.microservice.account.model.Product;

import java.util.Date;
import java.util.List;

public class OrderDTO
{
	private final Integer id;
	private Date date;
	private String direction;
	private final String accountName;
	private final List<Product> products;

	public OrderDTO(Integer id, Date date, String direction, String accountName, List<Product> products)
	{

		this.id = id;
		this.date = date;
		this.direction = direction;
		this.accountName = accountName;
		this.products = products;
	}

	public Integer getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public String getDirection()
	{
		return direction;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public List<Product> getProducts()
	{
		return products;
	}
}
