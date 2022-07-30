package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Courses {

	@Id
	@GeneratedValue
	private int cId;

	private String cName;

	private int cFees;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcFees() {
		return cFees;
	}

	public void setcFees(int cFees) {
		this.cFees = cFees;
	}

}
