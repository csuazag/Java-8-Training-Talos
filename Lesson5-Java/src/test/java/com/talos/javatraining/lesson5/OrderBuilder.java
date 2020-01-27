package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.OrderData;
import com.talos.javatraining.lesson5.data.OrderEntryData;
import com.talos.javatraining.lesson5.data.PriceData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static java.util.Optional.ofNullable;


public class OrderBuilder
{
	private String code;
	private List<OrderEntryData> entries = new ArrayList<>();

	public static OrderBuilder create()
	{
		return new OrderBuilder();
	}

	public OrderBuilder addEntry(OrderEntryData entry)
	{
		entries.add(entry);
		entry.setEntryNumber(entries.size());
		return this;
	}

	public OrderBuilder withCode(String code)
	{
		this.code = code;
		return this;
	}

	public OrderData build() {
		OrderData orderData = new OrderData();
		orderData.setCode(ofNullable(code).orElseGet(this::generateCode));
		orderData.setEntries(entries);
		orderData.setSubTotal(calculateSubTotal());
		return orderData;
	}

	private String generateCode()
	{
		return UUID.randomUUID().toString();
	}

	private PriceData calculateSubTotal()
	{
		BigDecimal subTotal = entries.stream().map(OrderEntryData::getBasePrice).map(PriceData::getValue).reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
		return PriceBuilder.create().withValue(subTotal).build();
	}

}
