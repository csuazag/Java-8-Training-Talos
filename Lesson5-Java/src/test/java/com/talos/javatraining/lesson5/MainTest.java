package com.talos.javatraining.lesson5;

import com.talos.javatraining.lesson5.data.OrderData;
import com.talos.javatraining.lesson5.data.ProductData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MainTest
{
	private static final String PRODUCT_1 = "12345";
	private static final String PRODUCT_2 = "23456";
	private static final String PRODUCT_3 = "34567";
	private static final String PRODUCT_4 = "45678";
	private static final String PRODUCT_5 = "56789";
	private static final String PRODUCT_6 = "67890";
	private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
	private static final BigDecimal FIVE_HUNDRED = BigDecimal.valueOf(500);
	private static List<OrderData> ORDERS;
	private Main main = new MainImpl();

	@BeforeClass
	public static void setupClass()
	{
		ORDERS = createOrders();
	}

	@Test
	public void testIsThereAnOrderWithPriceLowerThan100()
	{
		boolean result = main.isThereAnOrderWithPriceLowerThan(ORDERS, ONE_HUNDRED);

		assertFalse(result);
	}

	@Test
	public void testIsThereAnOrderWithPriceLowerThan500()
	{
		boolean result = main.isThereAnOrderWithPriceLowerThan(ORDERS, FIVE_HUNDRED);

		assertTrue(result);
	}

	@Test
	public void testAreThereAllOrdersWithPriceGreaterThan100()
	{
		boolean result = main.areThereAllOrdersWithPriceGreaterThan(ORDERS, ONE_HUNDRED);

		assertTrue(result);
	}

	@Test
	public void testAreThereAllOrdersWithPriceGreaterThan500()
	{
		boolean result = main.areThereAllOrdersWithPriceGreaterThan(ORDERS, FIVE_HUNDRED);

		assertFalse(result);
	}

	@Test
	public void testGetLowestOrderPrice()
	{
		BigDecimal result = main.getLowestOrderPrice(ORDERS);

		assertEquals(BigDecimal.valueOf(154.13d), result);
	}

	@Test
	public void testGetHighestOrderPrice()
	{
		BigDecimal result = main.getHighestOrderPrice(ORDERS);

		assertEquals(new BigDecimal("4725.97"), result);
	}

	@Test
	public void testCountOrdersWithPriceGreaterThan100()
	{
		long count = main.countOrdersWithPriceGreaterThan(ORDERS, ONE_HUNDRED);

		assertEquals(5L, count);
	}

	@Test
	public void testCountOrdersWithPriceGreaterThan500()
	{
		long count = main.countOrdersWithPriceGreaterThan(ORDERS, FIVE_HUNDRED);

		assertEquals(3L, count);
	}

	@Test
	public void testSumOrderPricesWithPriceLowerThan100()
	{
		BigDecimal result = main.sumOrderPricesWithPriceLowerThan(ORDERS, ONE_HUNDRED);

		assertEquals(BigDecimal.ZERO, result);
	}

	@Test
	public void testSumOrderPricesWithPriceLowerThan500()
	{
		BigDecimal result = main.sumOrderPricesWithPriceLowerThan(ORDERS, FIVE_HUNDRED);

		assertEquals(new BigDecimal("388.40"), result);
	}

	@Test
	public void testCountAllEntriesWithPriceGreaterThan100()
	{
		long count = main.countAllEntriesWithPriceGreaterThan(ORDERS, ONE_HUNDRED);

		assertEquals(9L, count);
	}

	@Test
	public void testCountAllEntriesWithPriceGreaterThan500()
	{
		long count = main.countAllEntriesWithPriceGreaterThan(ORDERS, FIVE_HUNDRED);

		assertEquals(5L, count);
	}

	@Test
	public void testCountEntriesWithProduct1()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_1);

		assertEquals(2L, count);
	}

	@Test
	public void testCountEntriesWithProduct2()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_2);

		assertEquals(2L, count);
	}

	@Test
	public void testCountEntriesWithProduct3()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_3);

		assertEquals(2L, count);
	}

	@Test
	public void testCountEntriesWithProduct4()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_4);

		assertEquals(2L, count);
	}

	@Test
	public void testCountEntriesWithProduct5()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_5);

		assertEquals(1L, count);
	}

	@Test
	public void testCountEntriesWithProduct6()
	{
		long count = main.countEntriesWithProduct(ORDERS, PRODUCT_6);

		assertEquals(3L, count);
	}

	@Test
	public void testSumQuantitiesForProduct1()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_1);

		assertEquals(6L, count);
	}

	@Test
	public void testSumQuantitiesForProduct2()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_2);

		assertEquals(4L, count);
	}

	@Test
	public void testSumQuantitiesForProduct3()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_3);

		assertEquals(6L, count);
	}

	@Test
	public void testSumQuantitiesForProduct4()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_4);

		assertEquals(5L, count);
	}

	@Test
	public void testSumQuantitiesForProduct5()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_5);

		assertEquals(1L, count);
	}

	@Test
	public void testSumQuantitiesForProduct6()
	{
		long count = main.sumQuantitiesForProduct(ORDERS, PRODUCT_6);

		assertEquals(10L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct1()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_1);

		assertEquals(5L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct2()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_2);

		assertEquals(2L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct3()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_3);

		assertEquals(3L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct4()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_4);

		assertEquals(3L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct5()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_5);

		assertEquals(1L, count);
	}

	@Test
	public void testGetMaxQuantityOrderedForProduct6()
	{
		long count = main.getMaxQuantityOrderedForProduct(ORDERS, PRODUCT_6);

		assertEquals(6L, count);
	}

	private static List<OrderData> createOrders()
	{
		Map<String, ProductData> products = createProducts();
		return Arrays.asList(
				OrderBuilder.create()
					.addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_1)).build()
					).build(),
				OrderBuilder.create()
					.addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_2)).withQuantity(2).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_4)).withQuantity(3).build()
					).build(),
				OrderBuilder.create()
					.addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_3)).withQuantity(3).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_6)).withQuantity(2).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_4)).withQuantity(2).build()
					).build(),
				OrderBuilder.create()
					.addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_1)).withQuantity(5).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_2)).withQuantity(2).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_3)).withQuantity(3).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_6)).withQuantity(6).build()
					).build(),
				OrderBuilder.create()
					.addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_5)).build()
					).addEntry(
							OrderEntryBuilder.create().withProduct(products.get(PRODUCT_6)).withQuantity(2).build()
					).build()
		);
	}

	private static Map<String, ProductData> createProducts()
	{
		List<ProductData> products = new ArrayList<>();
		products.add(ProductBuilder.create().withCode(PRODUCT_1).withName("Fireball").withPrice("234.27").build());
		products.add(ProductBuilder.create().withCode(PRODUCT_2).withName("Bump").withPrice("452.63").build());
		products.add(ProductBuilder.create().withCode(PRODUCT_3).withName("Merkur").withPrice("731.88").build());
		products.add(ProductBuilder.create().withCode(PRODUCT_4).withName("Paint").withPrice("32.13").build());
		products.add(ProductBuilder.create().withCode(PRODUCT_5).withName("Brush").withPrice("2.89").build());
		products.add(ProductBuilder.create().withCode(PRODUCT_6).withName("Tube").withPrice("75.62").build());
		return products.stream().collect(Collectors.toMap(ProductData::getCode, p -> p));
	}
}
