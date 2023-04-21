 package com.cg.couriermanagement.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="courier_office")
@ToString
@Data
public class CourierOfficeOutletEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int officeId;
	private String openingTime;
	private String closingTime;
	

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public CourierOfficeOutletEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
