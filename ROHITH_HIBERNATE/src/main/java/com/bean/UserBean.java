package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserBean {

	@Id
	@GeneratedValue
	private int uId;
	private String uName;
	private int uAge;

	@OneToOne(cascade = CascadeType.ALL)
	private AccountBean accountBean;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuAge() {
		return uAge;
	}

	public void setuAge(int uAge) {
		this.uAge = uAge;
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

}
