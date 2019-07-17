package com.example.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BrandListResposnseEntity {
	private String status;
	private String msg;
	private String code;
	private List<Brand> brand;
	
	public List<Brand> getBrand() {
		return brand;
	}
	public void setBrand(List<Brand> brand) {
		this.brand = brand;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
