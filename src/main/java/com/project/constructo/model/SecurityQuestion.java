/*package com.project.constructo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table
public class SecurityQuestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long qId;
	
	@Column
	private String qName;
	@JsonManagedReference
	@OneToMany (mappedBy = "sQuestion")
	private List <ConstructOwner> cOwner;

	public long getqId() {
		return qId;
	}

	public void setqId(long qId) {
		this.qId = qId;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public List<ConstructOwner> getcOwner() {
		return cOwner;
	}

	public void setcOwner(List<ConstructOwner> cOwner) {
		this.cOwner = cOwner;
	}
	
}*/
