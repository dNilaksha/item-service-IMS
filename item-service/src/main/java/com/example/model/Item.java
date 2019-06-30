package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String itemCode;
	@OneToOne(cascade = CascadeType.ALL)
	private Brand brand;
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	@OneToOne(cascade = CascadeType.ALL)
	private Uom uom;
	@OneToOne(cascade = CascadeType.ALL)
	private StorageArea storageArea;
	private Integer userId;
	private Date createDate;
	
	// --------getters & setters-------
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public StorageArea getStorageArea() {
		return storageArea;
	}
	public void setStorageArea(StorageArea storageArea) {
		this.storageArea = storageArea;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
}
