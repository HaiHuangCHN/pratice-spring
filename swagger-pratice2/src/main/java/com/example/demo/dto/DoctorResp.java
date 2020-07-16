package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Doctor object model") // Only to provide additional information
public class DoctorResp {
	private boolean isFound;
	@ApiModelProperty(value = "id of doctor", required = true)
	private Integer id;
	@ApiModelProperty(value = "name of doctor", required = true)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DemoDoctor [id=" + id + ", name=" + name + "]";
	}

}
