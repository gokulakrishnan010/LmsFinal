package com.tvscs.lms.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime localDate;
	private String statusCode;
	private String message;
	/**
	 * 
	 */
	public CustomErrorResponse() {
		super();
	}
	/**
	 * @return the localDate
	 */
	public LocalDateTime getLocalDate() {
		return localDate;
	}
	/**
	 * @param localDate the localDate to set
	 */
	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public static CustomErrorResponse getErrorObject(String statusCode, String message) {
		CustomErrorResponse cErrorResponse = new CustomErrorResponse();
		cErrorResponse.setLocalDate(LocalDateTime.now());
		cErrorResponse.setStatusCode(statusCode);
		cErrorResponse.setMessage(message);
		return cErrorResponse;
	}
	@Override
	public String toString() {
		return "CustomErrorResponse [localDate=" + localDate + ", statusCode=" + statusCode + ", message=" + message
				+ "]";
	}
	
	
}
