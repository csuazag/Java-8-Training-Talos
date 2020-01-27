package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.OrderData;
import java.math.BigDecimal;
import java.util.List;


public interface Main
{
	/**
	 * Indicates if there is an order with a subtotal lower than the given price.
	 *
	 * @param orders the orders
	 * @param price  the price
	 * @return indicates if there is an order with a subtotal lower than the given price
	 */
	boolean isThereAnOrderWithPriceLowerThan(List<OrderData> orders, BigDecimal price);

	/**
	 * Indicates if all the orders have a price greater than the given price.
	 *
	 * @param orders the orders
	 * @param price  the price
	 * @return indicates if all the orders have a price greater than the given price.
	 */
	boolean areThereAllOrdersWithPriceGreaterThan(List<OrderData> orders, BigDecimal price);

	/**
	 * Retrieves the lowest order price
	 *
	 * @param orders the orders
	 * @return the lowest order price
	 */
	BigDecimal getLowestOrderPrice(List<OrderData> orders);

	/**
	 * Retrieves the highest order price
	 *
	 * @param orders the orders
	 * @return the highest order prices
	 */
	BigDecimal getHighestOrderPrice(List<OrderData> orders);

	/**
	 * Counts the orders which price is greater than the given price
	 *
	 * @param orders the orders
	 * @param price  the price
	 * @return the count
	 */
	long countOrdersWithPriceGreaterThan(List<OrderData> orders, BigDecimal price);

	/**
	 * Sums the order prices which has a price lower than the given price
	 *
	 * @param orders the orders
	 * @param price  the price
	 * @return the sum total
	 */
	BigDecimal sumOrderPricesWithPriceLowerThan(List<OrderData> orders, BigDecimal price);

	/**
	 * Counts all the entries which has a base price greater than the given price
	 *
	 * @param orders the orders
	 * @param price  the price
	 * @return the count
	 */
	long countAllEntriesWithPriceGreaterThan(List<OrderData> orders, BigDecimal price);

	/**
	 * Counts all the entries which has a product with the given code
	 *
	 * @param orders      the orders
	 * @param productCode the product code
	 * @return the count
	 */
	long countEntriesWithProduct(List<OrderData> orders, String productCode);

	/**
	 * Sums all the entry quantities that has a product with the given code
	 *
	 * @param orders      the orders
	 * @param productCode the product code
	 * @return the sum total
	 */
	long sumQuantitiesForProduct(List<OrderData> orders, String productCode);

	/**
	 * Gets the maximum entry quantity that has been ordered with the given product code.
	 *
	 * @param orders      the orders
	 * @param productCode the product code
	 * @return the max quantity
	 */
	long getMaxQuantityOrderedForProduct(List<OrderData> orders, String productCode);
}
