package com.talos.javatraining.lesson5.data;

public class ProductData
{
	private String code;
	private String name;
	private PriceData price;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public PriceData getPrice()
	{
		return price;
	}

	public void setPrice(PriceData price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "ProductData{" +
				"code='" + code + '\'' +
				", price=" + price +
				'}';
	}
}
