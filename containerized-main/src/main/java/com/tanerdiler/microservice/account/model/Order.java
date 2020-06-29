package com.tanerdiler.microservice.account.model;

import java.util.Date;
import java.util.List;

public class Order
{
	private Integer id;
	private List<Integer> productId;
	private Integer accountId;
	private Date date;
	private String direction;

	public Order()
	{
	}

	public Order(List<Integer> productId, Integer accountId, Date date, String direction)
	{
		this.productId = productId;
		this.accountId = accountId;
		this.date = date;
		this.direction = direction;
	}

	public Order(Integer id, List<Integer> productId, Integer accountId, Date date, String direction)
	{
		this.id = id;
		this.productId = productId;
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

	public List<Integer> getProductId()
	{
		return productId;
	}

	public void setProductId(List<Integer> productId)
	{
		this.productId = productId;
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
