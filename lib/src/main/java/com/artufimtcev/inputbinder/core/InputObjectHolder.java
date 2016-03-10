package com.artufimtcev.inputbinder.core;

public abstract class InputObjectHolder {

	private Object mTarget;
	private String mPropertyName;


	public InputObjectHolder(Object target, String propertyName) {
		this.mTarget = target;
		this.mPropertyName = propertyName;
	}


	protected void setValue(Object value) {
		ReflectionUtility.setValue(mTarget, mPropertyName, value);
	}


	protected void setValue(boolean value) {
		ReflectionUtility.setValue(mTarget, mPropertyName, value);
	}
}
