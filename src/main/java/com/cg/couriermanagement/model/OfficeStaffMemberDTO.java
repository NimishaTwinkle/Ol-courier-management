package com.cg.couriermanagement.model;


import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class OfficeStaffMemberDTO {

	private int aadharNo;
	private String firstName;
	private String lastName;
	private long mobileNo;
	private int empId;
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
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
	public int getOfficeId() {
		return empId;
	}
	public void setOfficeId(int officeId) {
		this.empId = officeId;
	}
	
}
