package com.example.demo.models;

public class Suggestion {
	private Integer suggestionId;
	private Integer questId;
	private Integer productId;
	
	public Suggestion() {
		
	}
	
	public Suggestion(Integer suggestionId, Integer questId, Integer productId) {
		super();
		this.suggestionId = suggestionId;
		this.questId = questId;
		this.productId = productId;
	}

	public Integer getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(Integer suggestionId) {
		this.suggestionId = suggestionId;
	}

	public Integer getQuestId() {
		return questId;
	}

	public void setQuestId(Integer questId) {
		this.questId = questId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Suggestion [suggestionId=" + suggestionId + ", questId=" + questId + ", productId=" + productId
				+ "]";
	}
	
	
	
}
