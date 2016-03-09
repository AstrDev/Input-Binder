package com.artufimtcev.inputbinder.core;

import android.text.Editable;
import android.text.TextWatcher;


class TextWatcherImpl implements TextWatcher {

	private Object mObject;
	private String mProperty;


	TextWatcherImpl(Object object, String property) {
		this.mObject = object;
		this.mProperty = property;
	}


	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}


	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		ReflectionUtility.setValue(mObject, mProperty, s.toString());
	}


	@Override
	public void afterTextChanged(Editable s) {}
}
