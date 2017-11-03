package org.iss.workshop1.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DiscountEngine {

	public List<SalesItem> calculateItemDiscounts(List<SalesItem> items) {
		
		DiscountEngine engine = new DiscountEngine();
		Map<String, List<SalesItem>> buckets = engine.bucketItemsBySKU(items);
		
		// Calculate item discounts
		engine.processItemDiscounts(buckets);
		
		// DEBUG: Print item after bucketing
//		engine.printItemBucketInfo(buckets);
				
		return items;
	}
	
	public Double getItemListTotalDiscounts(List<SalesItem> items) {
		double totalDiscount = 0;
		for(SalesItem item : items) {
			totalDiscount += item.getDiscountAmt().doubleValue();
		}
		return Double.valueOf(totalDiscount);
	}
	
	private Map<String, List<SalesItem>> processItemDiscounts(Map<String, List<SalesItem>> buckets) {
		Iterator<String> itr1 = buckets.keySet().iterator();
		while(itr1.hasNext()) {
			String itemBaseSKU = itr1.next();
			List<SalesItem> skuItems = buckets.get(itemBaseSKU);
			
			for(int i=0;i<skuItems.size();i++) {
				SalesItem skuItem = skuItems.get(i);
				if(i%2!=0) {
					skuItem.setDiscountPct(Double.valueOf(30));
				}
			}
		}
		
		return buckets;
	}
	
	private void printItemBucketInfo(Map<String, List<SalesItem>> buckets) {
		Iterator<String> itr1 = buckets.keySet().iterator();
		while(itr1.hasNext()) {
			String itemBaseSKU = itr1.next();
			System.out.println("=== Printing item bucket: " + itemBaseSKU + " ===");
			List<SalesItem> skuItems = buckets.get(itemBaseSKU);
			
			for(SalesItem skuItem : skuItems) {
				System.out.println(skuItem);
			}
		}
	}
	
	private Map<String, List<SalesItem>> bucketItemsBySKU(List<SalesItem> items) {
		Map<String, List<SalesItem>> buckets = new HashMap<String, List<SalesItem>>();
		for(SalesItem item : items) {
			String itemBaseSKU = item.getBaseSKU();
			if(itemBaseSKU==null) continue;
			
			List<SalesItem> skuItems = buckets.get(itemBaseSKU);
			if(skuItems==null) {
				skuItems = new ArrayList<SalesItem>();
				skuItems.add(item);
				buckets.put(itemBaseSKU, skuItems);
			}
			else {
				skuItems.add(item);
			}
		}
		return buckets;
	}
}
