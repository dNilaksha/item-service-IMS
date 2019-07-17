package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class StorageAreaResposnseEntity {
	private String status;
	private String msg;
	private String code;
	private StorageArea storageArea;
	
	public StorageArea getStorageArea() {
		return storageArea;
	}
	public void setStorageArea(StorageArea storageArea) {
		this.storageArea = storageArea;
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
