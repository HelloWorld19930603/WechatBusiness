package com.yilin.app.common;

public class Json implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493265179641167222L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	
	public Json() {}
	
	public Json(boolean success) {
		this.success = success;
	}
	
	public Json(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void addMsg(String msg) {
		this.msg += msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
