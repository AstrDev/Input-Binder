package com.astrdev.inputbindersample.entity;

import android.databinding.BaseObservable;


public class UserEntity {

	private String name;
	private String surname;
	private int age;


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}
}
