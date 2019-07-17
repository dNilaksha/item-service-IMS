package com.example.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UomListResposnseEntity {
	private String status;
	private String msg;
	private String code;
	private List<Uom> uom;
	

	public List<Uom> getUom() {
		return uom;
	}
	public void setUom(List<Uom> uom) {
		this.uom = uom;
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
