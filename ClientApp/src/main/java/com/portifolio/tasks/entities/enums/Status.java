package com.portifolio.tasks.entities.enums;

public enum Status {
	
	COMPLETED(1),
	TBD(2);
	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static Status valueOf(int code) {
		for (Status value : Status.values()) {
			if (value.getCode() == code) {
				return value;
			} 
		}
		throw new IllegalArgumentException("Invalid Status code");
	}
}
