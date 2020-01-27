package com.talos.javatraining.lesson5.data;

public class OrderEntryData
{
	private Integer entryNumber;
	private Long quantity;
	private ProductData product;
	private PriceData basePrice;

	public Integer getEntryNumber()
	{
		return entryNumber;
	}

	public void setEntryNumber(Integer entryNumber)
	{
		this.entryNumber = entryNumber;
	}

	public Long getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Long quantity)
	{
		this.quantity = quantity;
	}

	public ProductData getProduct()
	{
		return product;
	}

	public void setProduct(ProductData product)
	{
		this.product = product;
	}

	public PriceData getBasePrice()
	{
		return basePrice;
	}

	public void setBasePrice(PriceData basePrice)
	{
		this.basePrice = basePrice;
	}

	@Override
	public String toString()
	{
		return "OrderEntryData{" +
				"entryNumber=" + entryNumber +
				", quantity=" + quantity +
				", product=" + product +
				", basePrice=" + basePrice +
				'}';
	}
}
