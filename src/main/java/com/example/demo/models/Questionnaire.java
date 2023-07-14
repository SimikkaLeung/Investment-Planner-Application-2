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
	private Integer questId;
	private Integer clientId;
	
	@NotNull
	@DecimalMin(value="0.01", message="The principal must be greater than zero.")
	@DecimalMax(value="999999999999999999.99", message="Our online tool cannot handle this amount of principal. Please book an appointment with a financial advisor.")
	private BigDecimal principal;
	
	@NotNull
	@DecimalMin(value="0.0000001", message="The rate must be greater than zero.")
	@DecimalMax(value="999.99", message="Our online tool cannot handle this interest rate. Please book an appointment with a financial advisor.")
	private BigDecimal targetRate;
	
	@NotNull
	@Min(value = 1, message="The number of days must be greater than zero.")
	@Max(value = 2147483647, message="Our online tool cannot handle this duration. Please book an appointment with a financial advisor.")
	private Integer numOfDays;
	private LocalDateTime submissionTime;
	
	public Questionnaire() {
		this.submissionTime = LocalDateTime.now();
	}
	
	public Questionnaire(Integer questId, Integer clientId, BigDecimal principal, BigDecimal targetRate,
			Integer numOfDays) {
		super();
		this.questId = questId;
		this.clientId = clientId;
		this.principal = principal;
		this.targetRate = targetRate;
		this.numOfDays = numOfDays;
		this.submissionTime = LocalDateTime.now();
	}

	public Integer getQuestId() {
		return questId;
	}

	public void setQuestId(Integer questId) {
		this.questId = questId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getTargetRate() {
		return targetRate;
	}

	public void setTargetRate(BigDecimal targetRate) {
		this.targetRate = targetRate;
	}

	public Integer getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) throws InvalidInputException {
		this.numOfDays = numOfDays;
	}

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}

	@Override
	public String toString() {
		return "Questionnaire [questId=" + questId + ", clientId=" + clientId + ", principal=" + principal
				+ ", targetRate=" + targetRate + ", numOfDays=" + numOfDays + ", submissionTime="
				+ submissionTime + "]";
	}
	
	
	
	
}
