package com.example.demo;

public class Outer {

	// private variable
	private String outerText = "I am the Outer private variable";

	// private Method
	private String outerMethod() {
		return innerText;
	}

	class Inner {
		private String innerMethod() {
			return outerText;
		}
	}

	// private variable
	private String innerText = "I am the Outer private variable";

	// private Method
	private String InnerMethod() {
		return outerText;
	}

}
