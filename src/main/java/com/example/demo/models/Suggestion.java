package com.example.demo.models;

public class Suggestion {
	private Integer suggestion_id;
	private Integer quest_id;
	private Integer product_id;
	
	public Suggestion() {
		
	}
	
	public Suggestion(Integer suggestion_id, Integer quest_id, Integer product_id) {
		super();
		this.suggestion_id = suggestion_id;
		this.quest_id = quest_id;
		this.product_id = product_id;
	}

	public Integer getSuggestion_id() {
		return suggestion_id;
	}

	public void setSuggestion_id(Integer suggestion_id) {
		this.suggestion_id = suggestion_id;
	}

	public Integer getQuest_id() {
		return quest_id;
	}

	public void setQuest_id(Integer quest_id) {
		this.quest_id = quest_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Suggestion [suggestion_id=" + suggestion_id + ", quest_id=" + quest_id + ", product_id=" + product_id
				+ "]";
	}
	
	
	
}
