package org.iss.workshop1.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.iss.workshop1.src.DiscountEngine;
import org.iss.workshop1.src.SalesItem;
import org.junit.Test;

public class DiscountUnitTest {

	@Test
	public void testCalculatedDiscount() {
		DiscountUnitTest testing = new DiscountUnitTest();
		
		// Generate a list of sample items
		List<SalesItem> items = testing.generateTestItems();
		
		// Calculate discounts
		DiscountEngine engine = new DiscountEngine();
		engine.calculateItemDiscounts(items);
		Double totalDiscounts = engine.getItemListTotalDiscounts(items);
		
		// verify results
		assertEquals(172.5, totalDiscounts.doubleValue(), 0.001);
	}
	
	private static List<SalesItem> generateTestItems() {
		List<SalesItem> items = new ArrayList<SalesItem>();
		
		items.add(new SalesItem("SKU123-L-DBL", "Polo T-Shirt, Large, Dark Blue", "L", "Dark Blue", Double.valueOf(10), Integer.valueOf(5)));
		items.add(new SalesItem("SKU123-M-DBL", "Polo T-Shirt, Medium, Dark Blue", "M", "Dark Blue", Double.valueOf(10), Integer.valueOf(5)));
		items.add(new SalesItem("SKU456-L-BK", "Men's Shorts, Large, Black", "L", "Black", Double.valueOf(5), Integer.valueOf(5)));
		items.add(new SalesItem("SKU456-L-BL", "Men's Shorts, Large, Blue", "L", "Blue", Double.valueOf(5), Integer.valueOf(5)));
		items.add(new SalesItem("SKU555-L-BL", "Men's Underwear, Large, Blue", "L", "Blue", Double.valueOf(3), Integer.valueOf(5)));
		items.add(new SalesItem("SKU999-US10-W", "Men's Running Shoes, US10, White", " US10", "White", Double.valueOf(100), Integer.valueOf(5)));
		items.add(new SalesItem("SKU888-US10-W", "Women's Running Shoes, US10, White", " US10", "White", Double.valueOf(100), Integer.valueOf(5)));
		items.add(new SalesItem("SKU888-US10-PK", "Women's Running Shoes, US10, Pink", " US10", "Pink", Double.valueOf(100), Integer.valueOf(5)));
		
		return items;
	}
}
