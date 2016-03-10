package com.artufimtcev.inputbinder.core;

import android.widget.CompoundButton;
import android.widget.EditText;


public final class BindingAdapter {

	private BindingAdapter() {}


	@android.databinding.BindingAdapter({"inputObject", "inputProperty"})
	public static void setInputListener(EditText editText, Object object, String propertyName) {
		if (editText == null) throw new IllegalArgumentException("EditText can't be null");
		if (object == null) throw new IllegalArgumentException("Target input object can't be null");
		if (propertyName == null || propertyName.equals("")) throw new IllegalArgumentException("Property name can't be null or empty");

		editText.addTextChangedListener(new TextWatcherImpl(object, propertyName));
	}


	@android.databinding.BindingAdapter({"inputObject", "inputProperty"})
	public static void setInputListener(CompoundButton compoundButton, Object object, String propertyName) {
		if (compoundButton == null) throw new IllegalArgumentException("View can't be null");
		if (object == null) throw new IllegalArgumentException("Target input object can't be null");
		if (propertyName == null || propertyName.equals("")) throw new IllegalArgumentException("Property name can't be null or empty");

		compoundButton.setOnClickListener(new OnClickListenerImpl(object, propertyName));
	}
}
