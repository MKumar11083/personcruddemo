package com.example.personcruddemo.utilities;

import java.util.List;
import java.util.Optional;

public class ServiceResponseEntity {

	private Integer code;
	private String message;
	private List<Object> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	
}
