package org.iss.workshop1.src;

public class SalesItem {

	private String skuCode;
	private String description;
	private String size;
	private String colour;
	private Double unitPrice;
	private Integer quantity;
	private Double discountPct;
	
	public SalesItem(String skuCode, String description, String size, String colour, Double unitPrice, Integer quantity) {
		super();
		this.skuCode = skuCode;
		this.description = description;
		this.size = size;
		this.colour = colour;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		
		this.discountPct = Double.valueOf(0);
	}
	
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getDiscountPct() {
		return discountPct;
	}
	public void setDiscountPct(Double discountPct) {
		this.discountPct = discountPct;
	}

	public String getBaseSKU() {
		if(this.skuCode==null || this.skuCode.length()==0) return null;

		String[] tokens = this.skuCode.split("-");
		return tokens[0];
	}
	
	public Double getItemTotal() {
		if(this.quantity==null || this.unitPrice==null) return Double.valueOf(0);
		
		return this.quantity.doubleValue() * this.unitPrice.doubleValue();
	}
	
	public Double getDiscountAmt() {
		if(this.quantity==null || this.unitPrice==null || this.discountPct==null) return Double.valueOf(0);
		
		return this.quantity.doubleValue() * this.unitPrice.doubleValue() * (this.discountPct/100);
	}
	
	public Double getItemDiscountedTotal() {
		if(this.quantity==null || this.unitPrice==null || this.discountPct==null) return Double.valueOf(0);
		
		return getItemTotal() - getDiscountAmt();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("SalesItem [skuCode=" + skuCode + ", description=" + description + ", size=" + size + ", colour="
				+ colour + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", itemTotal=" + getItemTotal());
		
		// Print discount if applicable
		if(getDiscountPct().doubleValue()!=0) {
			sb.append(", discountPct=" + discountPct + ", discountAmt=" + getDiscountAmt() + ", itemDiscountedTotal=" + getItemDiscountedTotal());
		}
		
		sb.append("]");
		return sb.toString();
	}
}
