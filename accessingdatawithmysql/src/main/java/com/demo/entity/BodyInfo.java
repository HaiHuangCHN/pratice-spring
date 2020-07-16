package com.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "body_Info_20181126", schema = "pratice")
public class BodyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bodyId;

	@Column(name = "weight", nullable = false, columnDefinition = "VARCHAR(10)")
	private String weight;

	@Column(name = "hight", nullable = false, columnDefinition = "VARCHAR(10)")
	private String hight;

	@Column(name = "created_date", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdDate;

	@Column(name = "updated_date", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedDate;

	protected BodyInfo() {
	}

	public BodyInfo(String weight, String hight) {
		this.weight = weight;
		this.hight = hight;
	}

	public int getBodyId() {
		return bodyId;
	}

	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}

	public String getWeight() {
		return weight;
	}

	public String getHight() {
		return hight;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setHight(String hight) {
		this.hight = hight;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}
