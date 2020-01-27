package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.PriceData;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import static java.util.Optional.ofNullable;


public class PriceBuilder
{
	private static final String USD = "USD";
	private BigDecimal value;
	private String currencyIso;

	public static PriceBuilder create()
	{
		return new PriceBuilder();
	}

	public PriceBuilder withValue(String value)
	{
		this.value = new BigDecimal(value);
		return this;
	}

	public PriceBuilder withValue(BigDecimal value)
	{
		this.value = value;
		return this;
	}

	public PriceBuilder withCurrencyIso(String currencyIso)
	{
		this.currencyIso = currencyIso;
		return this;
	}

	public PriceData build()
	{
		PriceData data = new PriceData();
		data.setValue(ofNullable(value).orElse(ZERO));
		data.setCurrencyIso(ofNullable(currencyIso).orElse(USD));
		return data;
	}

}
