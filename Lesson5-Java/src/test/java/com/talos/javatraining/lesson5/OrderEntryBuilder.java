package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.OrderEntryData;
import com.talos.javatraining.lesson5.data.PriceData;
import com.talos.javatraining.lesson5.data.ProductData;
import java.math.BigDecimal;


public class OrderEntryBuilder
{
	private long quantity = 1;
	private ProductData product;

	public static OrderEntryBuilder create()
	{
		return new OrderEntryBuilder();
	}

	public OrderEntryBuilder withQuantity(long quantity)
	{
		this.quantity = quantity;
		return this;
	}

	public OrderEntryBuilder withProduct(ProductData product)
	{
		this.product = product;
		return this;
	}

	public OrderEntryData build()
	{
		OrderEntryData entryData = new OrderEntryData();
		entryData.setQuantity(quantity);
		entryData.setProduct(product);
		entryData.setBasePrice(calculateBasePrice());
		return entryData;
	}

	private PriceData calculateBasePrice()
	{
		BigDecimal qty = BigDecimal.valueOf(quantity);
		BigDecimal basePrice = product.getPrice().getValue().multiply(qty);
		return PriceBuilder.create().withValue(basePrice).build();
	}

}
