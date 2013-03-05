package com.groupdocs;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;

public abstract class Base {
	protected String sampleName = "";

	public <T> boolean isValid(T response) {
		Method getStatus;
		Method getError_message;
		boolean result = false;
		try {
			getStatus = response.getClass().getDeclaredMethod("getStatus");
			result = "ok".equalsIgnoreCase(((String) getStatus.invoke(response))
					.trim());
			if (result == false) {
				getError_message = response.getClass().getDeclaredMethod(
						"getError_message");
				System.err.println(getError_message.invoke(response));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Before
	public void before() {
		System.out
				.println("---------------------------- " + sampleName + " ----------------------------");
	}

	@After
	public void after() {
		System.out
				.println("-------------------------- End " + sampleName + " --------------------------\r\n");
	}

}
