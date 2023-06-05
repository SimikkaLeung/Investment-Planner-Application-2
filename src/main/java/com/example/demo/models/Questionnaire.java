package com.example.demo.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.demo.exceptions.InvalidInputException;

public class Questionnaire {
	private Integer quest_id;
	private Integer client_id;
	
	@NotNull
	@DecimalMin(value="0.01", message="The principal must be greater than zero.")
	@DecimalMax(value="999999999999999999.99", message="Our online tool cannot handle this amount of principal. Please book an appointment with a financial advisor.")
	private BigDecimal principal;
	
	@NotNull
	@DecimalMin(value="0.0000001", message="The rate must be greater than zero.")
	@DecimalMax(value="999.99", message="Our online tool cannot handle this interest rate. Please book an appointment with a financial advisor.")
	private BigDecimal target_rate;
	
	@NotNull
	@Min(value = 1, message="The rate must be greater than zero.")
	@Max(value = 2147483647, message="Our online tool cannot handle this duration. Please book an appointment with a financial advisor.")
	private Integer num_of_days;
	private LocalDateTime submission_time;
	
	public Questionnaire() {
		this.submission_time = LocalDateTime.now();
	}
	
	public Questionnaire(Integer quest_id, Integer client_id, BigDecimal principal, BigDecimal target_rate,
			Integer num_of_days) {
		super();
		this.quest_id = quest_id;
		this.client_id = client_id;
		this.principal = principal;
		this.target_rate = target_rate;
		this.num_of_days = num_of_days;
		this.submission_time = LocalDateTime.now();
	}

	public Integer getQuest_id() {
		return quest_id;
	}

	public void setQuest_id(Integer quest_id) {
		this.quest_id = quest_id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getTarget_rate() {
		return target_rate;
	}

	public void setTarget_rate(BigDecimal target_rate) {
		this.target_rate = target_rate;
	}

	public Integer getNum_of_days() {
		return num_of_days;
	}

	public void setNum_of_days(Integer num_of_days) throws InvalidInputException {
		this.num_of_days = num_of_days;
	}

	public LocalDateTime getSubmission_time() {
		return submission_time;
	}

	public void setSubmission_time(LocalDateTime submission_time) {
		this.submission_time = submission_time;
	}

	@Override
	public String toString() {
		return "Questionnaire [quest_id=" + quest_id + ", client_id=" + client_id + ", principal=" + principal
				+ ", target_rate=" + target_rate + ", num_of_days=" + num_of_days + ", submission_time="
				+ submission_time + "]";
	}
	
	
	
	
}
