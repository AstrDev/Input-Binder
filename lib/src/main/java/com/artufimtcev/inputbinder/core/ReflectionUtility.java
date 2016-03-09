package com.artufimtcev.inputbinder.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public final class ReflectionUtility {

	private ReflectionUtility() {}

	public static void setValue(Object target, String propertyName, String value) {
		Method[] methods = target.getClass().getDeclaredMethods();
		String setterName = getSetterName(propertyName);
		for (Method method : methods) {
			if (method.getName().equals(setterName)) {
				try {
					attemptToCallSetter(method, target, value, propertyName);
					return;
				} catch(Exception e) {
					raiseArgumentException(target, propertyName);
				}
			}
		}
		raiseArgumentException(target, propertyName);
	}


	private static String getSetterName(String propertyName) {
		StringBuilder builder = new StringBuilder();
		builder.append("set")
				.append(Character.toUpperCase(propertyName.charAt(0)))
				.append(propertyName.substring(1));
		return builder.toString();
	}


	private static void attemptToCallSetter(Method method, Object target, String value, String propertyName) throws InvocationTargetException, IllegalAccessException {
		Class[] params = method.getParameterTypes();
		if (params.length == 1 && params[0] == String.class) {
			method.invoke(target, value);
		} else {
			raiseArgumentException(target, propertyName);
		}
	}


	private static void raiseArgumentException(Object target, String propertyName) {
		throw new IllegalArgumentException("Could not find setter for " + propertyName + " in class " +
				target.getClass().getSimpleName() + ". Check if method signature corresponds to JavaBeans naming convention and it " +
				"has single String argument.");
	}
}
