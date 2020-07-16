package com.example.demo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Length;

@XmlRootElement(name = "user", namespace = "http://test")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 7870351249722416047L;

	@Id
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NAME", length = 50)
	@Length(max = 50)
	private String name;

	@Column(name = "ADDRESS", length = 50)
	@Length(max = 50)
	private String address;

	@Column(name = "JOB", length = 50)
	@Length(max = 50)
	private String job;

	@XmlElementWrapper(name = "events") // To wrap a label within "events"
	@XmlElements(value = { @XmlElement(name = "event", type = Event.class) })
	@OneToMany(cascade = CascadeType.ALL)
	private List<Event> overinfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<Event> getOverinfos() {
		return overinfos;
	}

	public void setOverinfos(List<Event> overinfos) {
		this.overinfos = overinfos;
	}

}