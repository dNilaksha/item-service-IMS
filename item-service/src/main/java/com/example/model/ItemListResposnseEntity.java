package com.example.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ItemListResposnseEntity {
	private String status;
	private String msg;
	private String code;
	private List<Item> item;
	
	
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
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
