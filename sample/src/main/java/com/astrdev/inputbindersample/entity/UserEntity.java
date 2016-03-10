package com.astrdev.inputbindersample.entity;

import android.databinding.BaseObservable;


public class UserEntity {

	public static final int AGE_UNDEFINED = -1;

	private String name;
	private String surname;
	private int age = AGE_UNDEFINED;
	private boolean androidDeveloper;


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
		try {
			this.age = Integer.parseInt(age);
		} catch(Exception e) {
			this.age = AGE_UNDEFINED;
		}
	}


	public boolean isAndroidDeveloper() {
		return androidDeveloper;
	}


	public void setAndroidDeveloper(boolean androidDeveloper) {
		this.androidDeveloper = androidDeveloper;
	}
}
