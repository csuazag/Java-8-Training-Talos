package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.OrderData;
import com.talos.javatraining.lesson5.data.OrderEntryData;
import com.talos.javatraining.lesson5.data.ProductData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * This implementation uses a traditional for block. Since there are some parts with similar code we created some private methods to reuse that code.
 * However, we need to refactor this class to use streams instead. In that case the private methods are not longer necessary.
 */
public class MainImpl implements Main
{
	@Override
	public boolean isThereAnOrderWithPriceLowerThan(List<OrderData> orders, BigDecimal price)
	{

		return  orders.stream()
				.anyMatch(order -> order.getSubTotal().getValue().compareTo(price) < 0);


//		boolean result = false;
//		for (OrderData order : orders)
//		{
//			if (order.getSubTotal().getValue().compareTo(price) < 0)
//			{
//				result = true;
//				break;
//			}
//		}
//		return result;
	}

	@Override
	public boolean areThereAllOrdersWithPriceGreaterThan(List<OrderData> orders, BigDecimal price)
	{

		return orders.stream()
				.allMatch(order -> order.getSubTotal().getValue().compareTo(price) > 0);
//		boolean result = true;
//		for (OrderData order : orders)
//		{
//			if (order.getSubTotal().getValue().compareTo(price) <= 0)
//			{
//				// If there is only one lower or equal than the given price, it is false
//				result = false;
//				break;
//			}
//		}
//		return result;
	}

	@Override
	public BigDecimal getLowestOrderPrice(List<OrderData> orders)
	{
		 return orders.stream()
				 .map(order -> order.getSubTotal().getValue())
				 .min(BigDecimal::compareTo)
				 .get();


//		BigDecimal result = null;
//		for (OrderData order : orders)
//		{
//			BigDecimal currentPrice = order.getSubTotal().getValue();
//			if (result == null || currentPrice.compareTo(result) < 0)
//			{
//				result = currentPrice;
//			}
//		}
//		return result;
	}

	@Override
	public BigDecimal getHighestOrderPrice(List<OrderData> orders)
	{
		return orders.stream()
				.map(order -> order.getSubTotal().getValue())
				.max(BigDecimal::compareTo)
				.get();


//		BigDecimal result = null;
//		for (OrderData order : orders)
//		{
//			BigDecimal currentPrice = order.getSubTotal().getValue();
//			if (result == null || currentPrice.compareTo(result) > 0)
//			{
//				result = currentPrice;
//			}
//		}
//		return result;
	}

	@Override
	public long countOrdersWithPriceGreaterThan(List<OrderData> orders, BigDecimal price)
	{


		return orders.stream()
				.filter (order -> order.getSubTotal().getValue().compareTo(price) > 0)
				.count();

//		long count = 0;
//
//		for (OrderData order : orders)
//		{
//			if (order.getSubTotal().getValue().compareTo(price) > 0)
//			{
//				count++;
//			}
//		}
//		return count;
	}

	@Override
	public BigDecimal sumOrderPricesWithPriceLowerThan(List<OrderData> orders, BigDecimal price)
	{

		return orders.stream()
				.map(order -> order.getSubTotal().getValue())
				.filter(currentPrice -> currentPrice.compareTo(price) < 0)
				.reduce(BigDecimal.ZERO, (x,y) -> x.add(y));

//		BigDecimal total = BigDecimal.ZERO;
//
//		for (OrderData order : orders) {
//			BigDecimal currentPrice = order.getSubTotal().getValue();
//			if (currentPrice.compareTo(price) < 0) {
//				total = total.add(currentPrice);
//			}
//		}
//		return total;
	}

	@Override
	public long countAllEntriesWithPriceGreaterThan(List<OrderData> orders, BigDecimal price)
	{


		  return orders.stream()
				 .map(OrderData::getEntries)
				 .flatMap(orderEntryData -> orderEntryData.stream())
				 .filter(entry -> entry.getBasePrice().getValue().compareTo(price) > 0)
				  .count();


//		long count = 0;
//		for (OrderData order : orders)
//		{
//			for (OrderEntryData entry : order.getEntries())
//			{
//				if (entry.getBasePrice().getValue().compareTo(price) > 0)
//				{
//					count++;
//				}
//			}
//		}
//		return count;
	}

	@Override
	public long countEntriesWithProduct(List<OrderData> orders, String productCode)
	{

		return orders.stream()
				.map(OrderData::getEntries)
				.flatMap(orderEntryData -> orderEntryData.stream())
				.map(entry -> entry.getProduct())
				.filter(productData -> productData.getCode().equals(productCode))
				.count();

//		long count = 0;
//		for (OrderData order : orders)
//		{
//			for (OrderEntryData entry : order.getEntries())
//			{
//				ProductData productData = entry.getProduct();
//				if (productData.getCode().equals(productCode))
//				{
//					count++;
//				}
//			}
//		}
//		return count;
	}

	@Override
	public long sumQuantitiesForProduct(List<OrderData> orders, String productCode)
	{

		return orders.stream()
				.map(OrderData::getEntries)
				.flatMap(orderEntryData -> orderEntryData.stream())
				.filter(productData -> productData.getProduct().getCode().equals(productCode))
				.map(this::getQty)
				.reduce( (long) 0, (x, y) -> x + y);

//		long total = 0;
//		for (OrderData order : orders)
//		{
//			for (OrderEntryData entry : order.getEntries())
//			{
//				ProductData productData = entry.getProduct();
//				if (productData.getCode().equals(productCode))
//				{
//					total += getQty(entry);
//				}
//			}
//		}
//		return total;
	}

	@Override
	public long getMaxQuantityOrderedForProduct(List<OrderData> orders, String productCode)
	{


		 return orders.stream()
				.map(OrderData::getEntries)
				.flatMap(orderEntryData -> orderEntryData.stream())
				.filter(entryData -> entryData.getProduct().getCode().equals(productCode))
				.map(entryData -> getQty(entryData))
		 		.max(Long::compareTo)
		 		.get();



//		long max = 0;
//		for (OrderData order : orders)
//		{
//			for (OrderEntryData entry : order.getEntries())
//			{
//				ProductData productData = entry.getProduct();
//				if (productData.getCode().equals(productCode))
//				{
//					long quantity = getQty(entry);
//					if (quantity > max)
//					{
//						max = quantity;
//					}
//				}
//			}
//		}
//		return max;
	}

	private long getQty(OrderEntryData entry)
	{
		return Optional.ofNullable(entry.getQuantity()).orElse(0L);
	}
}
