package com.artufimtcev.inputbinder.core;

import android.widget.CheckBox;
import android.widget.EditText;


public final class BindingAdapter {

	private BindingAdapter() {}


	@android.databinding.BindingAdapter({"object", "property"})
	public static void setInputListener(EditText editText, Object object, String propertyName) {
		editText.addTextChangedListener(new TextWatcherImpl(object, propertyName));
	}


	@android.databinding.BindingAdapter({"object", "property"})
	public static void setInputListener(CheckBox checkBox, Object object, String propertyName) {

	}
}
