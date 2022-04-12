package com.project.constructo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class VisitBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long visit_Id;
	
	@ManyToOne
	@JoinColumn(name="usr_Id")
	FlatOwner fVisit;
	
	@ManyToOne
	@JoinColumn(name="construct_Id")
	ConstructOwner consowner;
	
	
	@Column
	private LocalDate visit_Date;
	
	@Column
	private String timeSlot;
	

	public ConstructOwner getConsowner() {
		return consowner;
	}

	public void setConsowner(ConstructOwner consowner) {
		this.consowner = consowner;
	}

	public long getVisit_Id() {
		return visit_Id;
	}

	public void setVisit_Id(long visit_Id) {
		this.visit_Id = visit_Id;
	}

	public FlatOwner getfVisit() {
		return fVisit;
	}

	public void setfVisit(FlatOwner fVisit) {
		this.fVisit = fVisit;
	}

	public LocalDate getVisit_Date() {
		return visit_Date;
	}

	public void setVisit_Date(LocalDate visit_Date) {
		this.visit_Date = visit_Date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	
	
}
