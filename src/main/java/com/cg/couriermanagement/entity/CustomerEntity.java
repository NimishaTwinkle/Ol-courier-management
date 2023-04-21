package com.cg.couriermanagement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="customer")
@ToString
@Data
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private long aadharNo;
	private String firstName;
	private String lastName;
	private long mobileNo;
	
//	@OneToOne
//	@JoinColumn(name="addressId")
//	private AddressEntity address;
	
	@OneToMany(targetEntity=ComplaintEntity.class)
	private List<ComplaintEntity> complaints;
	
	@OneToMany(targetEntity=CourierEntity.class)
	private List<CourierEntity> couriers;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

//	public AddressEntity getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressEntity address) {
//		this.address = address;
//	}

	public List<ComplaintEntity> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<ComplaintEntity> complaints) {
		this.complaints = complaints;
	}

	public List<CourierEntity> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<CourierEntity> couriers) {
		this.couriers = couriers;
	}

	
	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", aadharNo=" + aadharNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", complaints=" + complaints + ", couriers="
				+ couriers + "]";
	}

	
	public CustomerEntity(int customerId, long aadharNo, String firstName, String lastName, long mobileNo,
			List<ComplaintEntity> complaints, List<CourierEntity> couriers) {
		super();
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.complaints = complaints;
		this.couriers = couriers;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


