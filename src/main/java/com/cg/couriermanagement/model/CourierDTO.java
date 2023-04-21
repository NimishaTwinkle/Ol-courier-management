package com.cg.couriermanagement.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourierDTO {
	
	private int consignmentNo;
	private LocalDate initiatedDate;
	private LocalDate deliveredDate;
	private CourierStatus courierStatus;
	private int amount;
	private String destinationAddress;

	private int customerId;

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public CourierStatus getCourierStatus() {
		return courierStatus;
	}

	public void setCourierStatus(CourierStatus courierStatus) {
		this.courierStatus = courierStatus;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
