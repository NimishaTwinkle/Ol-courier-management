package com.cg.couriermanagement.model;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ComplaintDTO {
	private int consignmentNo;
	private String shortDescription;
	private String longDescripion;
	private int customerId;
	public int getConsignmentNo() {
		return consignmentNo;
	}
	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescripion() {
		return longDescripion;
	}
	public void setLongDescripion(String longDescripion) {
		this.longDescripion = longDescripion;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
