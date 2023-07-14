package com.example.demo.models;

import java.math.BigDecimal;

public class Product {
	private Integer productId;
	private String productName;
	private String productType;
	private Integer numOfDays;
	private BigDecimal interestRate;
	private BigDecimal minPrincipal;
	private BigDecimal maxPrincipal;
	private Integer daysPerCompounding;
	private BigDecimal effectiveRate;
	private String productDesc;
	
	
	public Product() {
		super();
	}
	
	public Product(Integer productId, String productName, String productType, Integer numOfDays,
			BigDecimal interestRate, BigDecimal minPrincipal, BigDecimal maxPrincipal, Integer daysPerCompounding,
			BigDecimal effectiveRate, String productDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.numOfDays = numOfDays;
		this.interestRate = interestRate;
		this.minPrincipal = minPrincipal;
		this.maxPrincipal = maxPrincipal;
		this.daysPerCompounding = daysPerCompounding;
		this.effectiveRate = effectiveRate;
		this.productDesc = productDesc;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
		//Since Java does not support the calculation of the power of two BigDecimal values, 
		//This application will update the interest rate in the database 
		//and fetch the new effective rate from the database instead. 
	}

	public BigDecimal getMinPrincipal() {
		return minPrincipal;
	}

	public void setMinPrincipal(BigDecimal minPrincipal) {
		this.minPrincipal = minPrincipal;
	}

	public BigDecimal getMaxPrincipal() {
		return maxPrincipal;
	}

	public void setMaxPrincipal(BigDecimal maxPrincipal) {
		this.maxPrincipal = maxPrincipal;
	}

	public Integer getDaysPerCompounding() {
		return daysPerCompounding;
	}

	public void setDaysPerCompounding(Integer daysPerCompounding) {
		this.daysPerCompounding = daysPerCompounding;
		//Since Java does not support the calculation of the power of two BigDecimal values, 
		//This application will update the day per compound period in the database and 
		// fetch the new effective rate from the database instead. 
	}

	public BigDecimal getEffectiveRate() {
		return effectiveRate;
	}

	public void setEffectiveRate(BigDecimal effectiveRate) {
		this.effectiveRate = effectiveRate;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", numOfDays=" + numOfDays + ", interestRate=" + interestRate + ", minPrincipal="
				+ minPrincipal + ", maxPrincipal=" + maxPrincipal + ", daysPerCompounding=" + daysPerCompounding
				+ ", effectiveRate=" + effectiveRate + ", productDesc=" + productDesc + "]";
	}
	
	
}
