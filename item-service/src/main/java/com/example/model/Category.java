package com.example.model;

public class Category {
	private Integer id;
	private String name;
	private Integer criticalLevel;
	private Integer reOrderLevel;
	private Integer maxLevel;
	
	// --------getters & setters-------
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCriticalLevel() {
		return criticalLevel;
	}
	public void setCriticalLevel(Integer criticalLevel) {
		this.criticalLevel = criticalLevel;
	}
	public Integer getReOrderLevel() {
		return reOrderLevel;
	}
	public void setReOrderLevel(Integer reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}
	public Integer getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	
	
	

}
