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
public class Updates {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long updateId;
	
	@ManyToOne
	@JoinColumn(name="cId")
	ConstructOwner cOwnerUpdate;
	
	@Column
	private String img;
	
	@Column
	private String Details;
	
	@Column
	private String UpdateDate;

	public long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}

	public ConstructOwner getcOwnerUpdate() {
		return cOwnerUpdate;
	}

	public void setcOwnerUpdate(ConstructOwner cOwnerUpdate) {
		this.cOwnerUpdate = cOwnerUpdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}


	
}
