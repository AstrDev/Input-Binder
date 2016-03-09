package com.astrdev.inputbindersample.viewmodel;

import android.databinding.Bindable;

import com.astrdev.inputbindersample.BR;
import com.astrdev.inputbindersample.databinding.ActivityMainBinding;
import com.astrdev.inputbindersample.entity.UserEntity;

import cz.kinst.jakub.viewmodelbinding.ViewModel;


public class MainViewModel extends ViewModel<ActivityMainBinding> {

	public static final String INPUT_NAME = "name";
	public static final String INPUT_SURNAME = "surname";
	public static final String INPUT_AGE = "age";

	private UserEntity mUserEntity = new UserEntity();


	@Bindable
	public Object getInputObject() {
		return mUserEntity;
	}


	@Bindable
	public String getName() {
		return mUserEntity.getName();
	}


	@Bindable
	public String getSurname() {
		return mUserEntity.getSurname();
	}


	@Bindable
	public String getAge() {
		return Integer.toString(mUserEntity.getAge());
	}


	public void setName(String name) {
		mUserEntity.setName(name);
		notifyPropertyChanged(BR.name);
	}


	public void setSurname(String surname) {
		mUserEntity.setSurname(surname);
		notifyPropertyChanged(BR.surname);
	}


	public void setAge(String age) {
		mUserEntity.setAge(age);
		notifyPropertyChanged(BR.age);
	}
}
