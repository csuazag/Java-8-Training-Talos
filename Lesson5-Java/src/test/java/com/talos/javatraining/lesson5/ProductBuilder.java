package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.PriceData;
import com.talos.javatraining.lesson5.data.ProductData;
import java.math.BigDecimal;
import java.util.UUID;
import static java.util.Optional.ofNullable;


public class ProductBuilder
{
	private String code;
	private String name;
	private PriceData priceData;

	public static ProductBuilder create()
	{
		return new ProductBuilder();
	}

	public ProductBuilder withCode(String code)
	{
		this.code = code;
		return this;
	}

	public ProductBuilder withName(String name)
	{
		this.name = name;
		return this;
	}

	public ProductBuilder withPrice(String value)
	{
		this.priceData = PriceBuilder.create().withValue(value).build();
		return this;
	}

	public ProductBuilder withPrice(BigDecimal value)
	{
		this.priceData = PriceBuilder.create().withValue(value).build();
		return this;
	}

	public ProductBuilder withPrice(PriceData priceData)
	{
		this.priceData = priceData;
		return this;
	}

	public ProductData build()
	{
		ProductData productData = new ProductData();
		productData.setCode(ofNullable(code).orElseGet(this::generateCode));
		productData.setName(name);
		productData.setPrice(ofNullable(priceData).orElseGet(this::createZeroPrice));
		return productData;
	}

	private String generateCode()
	{
		return UUID.randomUUID().toString();
	}

	private PriceData createZeroPrice()
	{
		return PriceBuilder.create().withValue(BigDecimal.ZERO).build();
	}
}
