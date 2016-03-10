package com.artufimtcev.inputbinder.core;

import android.text.Editable;
import android.text.TextWatcher;


class TextWatcherImpl extends InputObjectHolder implements TextWatcher {

	public TextWatcherImpl(Object target, String propertyName) {
		super(target, propertyName);
	}


	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}


	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		setValue(s.toString());
	}


	@Override
	public void afterTextChanged(Editable s) {}
}
