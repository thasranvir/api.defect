/**
 * 
 */
package com.cognizant.defect.model;

import java.io.Serializable;

/**
 * @author 256624
 *
 */
public class Defect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8942887594621590360L;
	int id;
	String description;
	String dateRaised;
	String dateDelivered;
	String priority;
	String comments;
	String status ;
	String assignedTo;
	String eta;
	String category;
	String attachments;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the date_raised
	 */
	public String getDateRaised() {
		return dateRaised;
	}
	/**
	 * @param date_raised the date_raised to set
	 */
	public void setDateRaised(String dateRaised) {
		this.dateRaised = dateRaised;
	}
	/**
	 * @return the date_delivered
	 */
	public String getDateDelivered() {
		return dateDelivered;
	}
	/**
	 * @param date_delivered the date_delivered to set
	 */
	public void setDateDelivered(String dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	/**
	 * @return the assigned_to
	 */
	public String getAssignedTo() {
		return assignedTo;
	}
	/**
	 * @param assigned_to the assigned_to to set
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	/**
	 * @return the eta
	 */
	public String getEta() {
		return eta;
	}
	/**
	 * @param eta the eta to set
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the attachments
	 */
	public String getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	
	
}
