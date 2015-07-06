/**
 * 
 */
package com.cognizant.defect.model;

import java.io.Serializable;
import com.cognizant.defect.Exception.Error;

/**
 * @author 256624
 *
 */
public class DefectResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1167697371457765936L;
	
	private String status;
	private Error error;
	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
