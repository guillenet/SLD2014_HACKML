package com.mpago.domain;

public class Transaction {
	
	private String id;
	private String dateCreated;
	private String dateApproved;
	private String externalReference;
	private String description;
	private String totalPaid;
	private String shipCost;
	private String status;
	private String paymentType;
	private String operationType;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getDateApproved() {
		return dateApproved;
	}
	
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	
	public String getExternalReference() {
		return externalReference;
	}
	
	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTotalPaid() {
		return totalPaid;
	}
	
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}
	
	public String getShipCost() {
		return shipCost;
	}
	
	public void setShipCost(String shipCost) {
		this.shipCost = shipCost;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getOperationType() {
		return paymentType;
	}
	
	public void setOperationType(String opType) {
		this.operationType = opType;
	}
	
}
