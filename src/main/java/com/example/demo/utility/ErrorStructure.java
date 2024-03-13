package com.example.demo.utility;

public class ErrorStructure<G> {

	private int errorStatusCode;
	private String errorMessage;
	private G errorData;
	
	
	public int getErrorStatusCode() {
		return errorStatusCode;
	}
	public void setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public G getErrorData() {
		return errorData;
	}
	public void setErrorData(G errorData) {
		this.errorData = errorData;
	}
	
}
