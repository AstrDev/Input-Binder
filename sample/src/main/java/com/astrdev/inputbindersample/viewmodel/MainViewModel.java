package com.astrdev.inputbindersample.viewmodel;

import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.astrdev.inputbindersample.databinding.ActivityMainBinding;
import com.astrdev.inputbindersample.entity.UserEntity;

import cz.kinst.jakub.viewmodelbinding.ViewModel;


public class MainViewModel extends ViewModel<ActivityMainBinding> {

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
		return mUserEntity.getAge() == UserEntity.AGE_UNDEFINED ? "Undefined" : Integer.toString(mUserEntity.getAge());
	}


	@Bindable
	public String getAndroidDeveloper() {
		if(mUserEntity.isAndroidDeveloper()) {
			return "The person is an android developer";
		} else {
			return "The person is not an android developer";
		}
	}


	public UserEntity getUser() {
		return mUserEntity;
	}


	public void submit(View v) {
		// Here you have access to all user input from your entity
		Log.d("InputBinder", "User name: " + mUserEntity.getName());
		Log.d("InputBinder", "User surname: " + mUserEntity.getSurname());
		Log.d("InputBinder", "User age: " + mUserEntity.getAge());
		Log.d("InputBinder", "User is an android developer: " + (mUserEntity.isAndroidDeveloper() ? "yes" : "no"));
		notifyChange();
		getBinding().activityMainOutput.setVisibility(View.VISIBLE);
	}
}
