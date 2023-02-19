package com.samuelpace.todo.services.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long timemstamp;
	private String msg;
	private Integer status;

	public StandardError() {
		super();
	}

	public StandardError(Long timemstamp, Integer status, String msg) {
		super();
		this.timemstamp = timemstamp;
		this.msg = msg;
		this.status = status;
	}

	public Long getTimemstamp() {
		return timemstamp;
	}

	public void setTimemstamp(Long timemstamp) {
		this.timemstamp = timemstamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
