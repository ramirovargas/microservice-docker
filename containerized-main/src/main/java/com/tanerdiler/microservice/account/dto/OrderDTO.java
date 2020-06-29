package com.tanerdiler.microservice.account.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO
{
	private final Integer id;
	private Date date;
	private String direction;
	private final String accountName;
	private final List<String> productName;

	public OrderDTO(Integer id, Date date, String direction, String accountName, List<String> productName)
	{

		this.id = id;
		this.date = date;
		this.direction = direction;
		this.accountName = accountName;
		this.productName = productName;
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

	public List<String> getProductName()
	{
		return productName;
	}
}
