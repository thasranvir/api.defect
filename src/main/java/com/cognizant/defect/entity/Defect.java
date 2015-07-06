package com.cognizant.defect.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the defects database table.
 * 
 */
@Entity
@Table(name="defects")
@NamedQueries({
		@NamedQuery(name="Defect.findAll", query="SELECT d FROM Defect d"),
		@NamedQuery(name="Defect.updateDefect", query="UPDATE Defect d SET assigned_to=:assignedTo, category=:category, "
				+ "comments=:comments, date_delivered=:dateDelivered, date_raised=:dateRaised, description=:description, "
				+ "eta=:eta, priority=:priority, status=:status WHERE d.id=:id")
})

public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="assigned_to")
	private String assignedTo;
	
	@Column(name="category")
	private String category;
	
	@Column(name="comments")
	private String comments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_delivered")
	private Date dateDelivered;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_raised")
	private Date dateRaised;
	
	@Column(name="description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="eta")
	private Date eta;

	@Column(name="priority")
	private String priority;

	@Column(name="status")
	private String status;

	public Defect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateDelivered() {
		return this.dateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public Date getDateRaised() {
		return this.dateRaised;
	}

	public void setDateRaised(Date dateRaised) {
		this.dateRaised = dateRaised;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEta() {
		return this.eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}