package com.example.demo.models;

import java.math.BigDecimal;

public class Product {
	private Integer product_id;
	private String product_name;
	private String product_type;
	private Integer num_of_days;
	private BigDecimal interest_rate;
	private BigDecimal min_principal;
	private BigDecimal max_principal;
	private Integer days_per_compounding;
	private BigDecimal effective_rate;
	private String product_desc;
	
	
	public Product() {
		super();
	}
	
	public Product(Integer product_id, String product_name, String product_type, Integer num_of_days,
			BigDecimal interest_rate, BigDecimal min_principal, BigDecimal max_principal, Integer days_per_compounding,
			BigDecimal effective_rate, String product_desc) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.num_of_days = num_of_days;
		this.interest_rate = interest_rate;
		this.min_principal = min_principal;
		this.max_principal = max_principal;
		this.days_per_compounding = days_per_compounding;
		this.effective_rate = effective_rate;
		this.product_desc = product_desc;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public Integer getNum_of_days() {
		return num_of_days;
	}

	public void setNum_of_days(Integer num_of_days) {
		this.num_of_days = num_of_days;
	}

	public BigDecimal getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
		//Since Java does not support the calculation of the power of two BigDecimal values, 
		//This application will update the interest rate in the database 
		//and fetch the new effective rate from the database instead. 
	}

	public BigDecimal getMin_principal() {
		return min_principal;
	}

	public void setMin_principal(BigDecimal min_principal) {
		this.min_principal = min_principal;
	}

	public BigDecimal getMax_principal() {
		return max_principal;
	}

	public void setMax_principal(BigDecimal max_principal) {
		this.max_principal = max_principal;
	}

	public Integer getDays_per_compounding() {
		return days_per_compounding;
	}

	public void setDays_per_compounding(Integer days_per_compounding) {
		this.days_per_compounding = days_per_compounding;
		//Since Java does not support the calculation of the power of two BigDecimal values, 
		//This application will update the day per compound period in the database and 
		// fetch the new effective rate from the database instead. 
	}

	public BigDecimal getEffective_rate() {
		return effective_rate;
	}

	public void setEffective_rate(BigDecimal effective_rate) {
		this.effective_rate = effective_rate;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_type=" + product_type
				+ ", num_of_days=" + num_of_days + ", interest_rate=" + interest_rate + ", min_principal="
				+ min_principal + ", max_principal=" + max_principal + ", days_per_compounding=" + days_per_compounding
				+ ", effective_rate=" + effective_rate + ", product_desc=" + product_desc + "]";
	}
	
	
}
