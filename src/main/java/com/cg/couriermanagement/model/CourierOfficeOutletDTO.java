package com.cg.couriermanagement.model;

import java.time.LocalTime;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CourierOfficeOutletDTO { 
	private String openingTime;
	private String closingTime; 
	
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
	
	
}
