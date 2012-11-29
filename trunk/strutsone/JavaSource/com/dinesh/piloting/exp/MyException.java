package com.dinesh.piloting.exp;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "MyStruts : "+super.getMessage();
	}
}
