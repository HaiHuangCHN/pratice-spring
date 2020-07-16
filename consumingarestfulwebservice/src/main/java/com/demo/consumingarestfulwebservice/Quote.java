package com.demo.consumingarestfulwebservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // It’s annotated with @JsonIgnoreProperties from the Jackson JSON
											// processing library to indicate that any properties not bound in this type
											// should be ignored.
public class Quote {

	private String type;
	private Value value;

	public Quote() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Quote{" + "type='" + type + '\'' + ", value=" + value + '}';
	}
}