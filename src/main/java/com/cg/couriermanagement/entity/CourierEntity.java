package com.cg.couriermanagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.couriermanagement.model.CourierStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="courier")
@ToString
@Data
public class CourierEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courierId;
	private int consignmentNo;
	private LocalDate initiatedDate;
	private LocalDate deliveredDate;
	private CourierStatus courierStatus;
	private int amount;
	private String destinationAddress;
//	@ManyToOne	
//	@JsonIgnore
//	private CustomerEntity customer;
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
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
//	public CustomerEntity getCustomer() {
//		return customer;
//	}
//	public void setCustomer(CustomerEntity customer) {
//		this.customer = customer;
//	}
//	@Override
//	public String toString() {
//		return "CourierEntity [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
//				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", courierStatus=" + courierStatus + ", amount="
//				+ amount + ", destinationAddress=" + destinationAddress + ", customer=" + customer + "]";
//	}
//	public CourierEntity(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate,
//			CourierStatus courierStatus, int amount, String destinationAddress, CustomerEntity customer) {
//		super();
//		this.courierId = courierId;
//		this.consignmentNo = consignmentNo;
//		this.initiatedDate = initiatedDate;
//		this.deliveredDate = deliveredDate;
//		this.courierStatus = courierStatus;
//		this.amount = amount;
//		this.destinationAddress = destinationAddress;
//		this.customer = customer;
//	}
//	public CourierEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	
}
