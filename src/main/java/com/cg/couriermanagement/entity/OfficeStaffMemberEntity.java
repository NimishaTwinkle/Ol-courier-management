package com.cg.couriermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="officestaff")
@ToString
@Data
public class OfficeStaffMemberEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private int aadharNo;
	private String firstName;
	private String lastName;
	private long mobileNo;
		
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
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
	
	public OfficeStaffMemberEntity(int empId, int aadharNo, String firstName, String lastName, long mobileNo) {
		super();
		this.empId = empId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "OfficeStaffMemberEntity [empId=" + empId + ", aadharNo=" + aadharNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo + "]";
	}
	public OfficeStaffMemberEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
