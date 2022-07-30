package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abc")
public class Abc {

	@Id
	@GeneratedValue
	int id;
}
