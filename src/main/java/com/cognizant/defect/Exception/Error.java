/**
 * 
 */
package com.cognizant.defect.Exception;

import org.springframework.http.HttpStatus;

/**
 * @author 256624
 *
 */
public class Error {
	private HttpStatus errorCode;
	private String errorMessage;
	/**
	 * @return the errorCode
	 */
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
