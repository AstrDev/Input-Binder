package com.artufimtcev.inputbinder.core;

import java.lang.reflect.Method;


public final class ReflectionUtility {

	private ReflectionUtility() {}


	public static void setValue(Object target, String propertyName, Object value) {
		// Find corresponding setter for given property
		Method method = getSetterForProperty(target.getClass(), propertyName, value.getClass());
		if(method != null) {
			try {
				// Invoke the method with given value
				method.invoke(target, value);
			} catch(Exception e) {
				raiseArgumentException(target, propertyName);
			}
		} else {
			// Method wasn't found
			raiseArgumentException(target, propertyName);
		}
	}


	public static void setValue(Object target, String propertyName, boolean value) {
		// Find corresponding setter for given property
		Method method = getSetterForProperty(target.getClass(), propertyName, boolean.class);
		if(method != null) {
			try {
				// Invoke the method with given value
				method.invoke(target, value);
			} catch(Exception e) {
				raiseArgumentException(target, propertyName);
			}
		} else {
			// Method wasn't found
			raiseArgumentException(target, propertyName);
		}
	}


	private static Method getSetterForProperty(Class targetClass, String propertyName, Class argumentType) {
		Method[] methods = targetClass.getDeclaredMethods();
		// Get proper setter name that corresponds to JavaBeans naming convention
		String setterName = getSetterName(propertyName);
		for(Method method : methods) {
			// Check if the method has exactly 1 parameter with correct type
			if(method.getName().equals(setterName) && method.getParameterTypes().length == 1 &&
					method.getParameterTypes()[0] == argumentType) {
				return method;

			}
		}
		return null;
	}


	private static String getSetterName(String propertyName) {
		// Build setter name from property name
		StringBuilder builder = new StringBuilder();
		builder.append("set")
				.append(Character.toUpperCase(propertyName.charAt(0)))
				.append(propertyName.substring(1));
		return builder.toString();
	}


	private static void raiseArgumentException(Object target, String propertyName) {
		throw new IllegalArgumentException("Could not find setter for " + propertyName + " in class " +
				target.getClass().getSimpleName() + ". Check if method signature corresponds to JavaBeans naming convention and it " +
				"has single String argument.");
	}
}
