package com.talos.javatraining.lesson5.data;

import java.util.List;


public class OrderData
{
	private String code;
	private List<OrderEntryData> entries;
	private PriceData subTotal;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public List<OrderEntryData> getEntries()
	{
		return entries;
	}

	public void setEntries(List<OrderEntryData> entries)
	{
		this.entries = entries;
	}

	public PriceData getSubTotal()
	{
		return subTotal;
	}

	public void setSubTotal(PriceData subTotal)
	{
		this.subTotal = subTotal;
	}

	@Override
	public String toString()
	{
		return "OrderData{" +
				"code='" + code + '\'' +
				", entries=" + entries +
				", subTotal=" + subTotal +
				'}';
	}
}
