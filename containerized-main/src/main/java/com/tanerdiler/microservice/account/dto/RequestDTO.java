package com.tanerdiler.microservice.account.dto;

import com.tanerdiler.microservice.account.model.Product;

import java.util.Date;
import java.util.List;

public class RequestDTO
{
	private Integer id;
	private Date date;
	private String direction;
	private Integer accountId;
	private List<Product> products;

	public RequestDTO(Integer id, Date date, String direction, Integer accountId, List<Product> products)
	{

		this.id = id;
		this.date = date;
		this.direction = direction;
		this.accountId = accountId;
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

	public Integer getAccountId() { return accountId; }

	public List<Product> getProducts()
	{
		return products;
	}
}
