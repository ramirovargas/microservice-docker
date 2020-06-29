package com.tanerdiler.microservice.account.dto;

import com.tanerdiler.microservice.account.model.Product;

import java.util.List;

public class ProductDTO
{
    private List<Product> products;

    public ProductDTO(List<Product> products)
    {
        this.products = products;
    }

    public ProductDTO(){}

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }
}
