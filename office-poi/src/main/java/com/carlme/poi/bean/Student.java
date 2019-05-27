package com.carlme.poi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Student {
	private long id;
	private String name;
	private int age;
	private boolean sex;
	private Date birthday;
}