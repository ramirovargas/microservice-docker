package com.tanerdiler.microservice.account.model;

import java.util.Date;
import java.util.List;

public class Order
{
	private Integer id;
	private List<Product> products;
	private Integer accountId;
	private Date date;
	private String direction;

	public Order()
	{
	}

	public Order(List<Product> products, Integer accountId, Date date, String direction)
	{
		this.products = products;
		this.accountId = accountId;
		this.date = date;
		this.direction = direction;
	}

	public Order(Integer id, List<Product> products, Integer accountId, Date date, String direction)
	{
		this.id = id;
		this.products = products;
		this.accountId = accountId;
		this.date = date;
		this.direction = direction;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

	public Integer getAccountId()
	{
		return accountId;
	}

	public void setAccountId(Integer accountId)
	{
		this.accountId = accountId;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getDirection()
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}
}
