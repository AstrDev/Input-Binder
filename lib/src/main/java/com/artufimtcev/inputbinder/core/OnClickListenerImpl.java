package com.artufimtcev.inputbinder.core;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;


class OnClickListenerImpl extends InputObjectHolder implements View.OnClickListener {


	public OnClickListenerImpl(Object target, String propertyName) {
		super(target, propertyName);
	}


	@Override
	public void onClick(View v) {
		if (v instanceof CompoundButton) {
			setValue(((CompoundButton) v).isChecked());
		}
	}
}
