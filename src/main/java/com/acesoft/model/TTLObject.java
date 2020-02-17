package com.acesoft.model;

public class TTLObject {

	long timestamp;
	String value;

	public TTLObject(String val, long timestampV) {
		this.timestamp = timestampV;
		this.value = val;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setTimestamp(long timestampV) {
		this.timestamp = timestampV;
	}

	public void setValue(String val) {
		this.value = val;
	}
}