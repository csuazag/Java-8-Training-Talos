package com.talos.javatraining.lesson5.data;

import java.math.BigDecimal;


public class PriceData
{
	private BigDecimal value;
	private String currencyIso;

	public BigDecimal getValue()
	{
		return value;
	}

	public void setValue(BigDecimal value)
	{
		this.value = value;
	}

	public String getCurrencyIso()
	{
		return currencyIso;
	}

	public void setCurrencyIso(String currencyIso)
	{
		this.currencyIso = currencyIso;
	}

	@Override
	public String toString()
	{
		return "PriceData{" +
				"value=" + value +
				", currencyIso='" + currencyIso + '\'' +
				'}';
	}


}
