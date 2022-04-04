package com.project.constructo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class FlatOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long uId;
	
	@ManyToOne
	@JoinColumn (name="cId")
	ConstructOwner cOwner;  
	
	@Column
	private String usr_Name;
	
	@Column
	private String name;
	
	
	@Column
	private String phone_No;
	
	@Column
	private int usr_Key;
	
	@Column
	private long Total_amount;
	
	@Column
	private long paid_amount;
	
	@Column
	private long next_installment;
	
	@Column
	private LocalDate possesion_Date;
	
	@Column
	private String usr_Password;
	
	@OneToMany(mappedBy = "fVisit")
	private List <VisitBook> vBook;

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public ConstructOwner getcOwner() {
		return cOwner;
	}

	public void setcOwner(ConstructOwner cOwner) {
		this.cOwner = cOwner;
	}

	public String getUsr_Name() {
		return usr_Name;
	}

	public void setUsr_Name(String usr_Name) {
		this.usr_Name = usr_Name;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public int getUsr_Key() {
		return usr_Key;
	}

	public void setUsr_Key(int usr_Key) {
		this.usr_Key = usr_Key;
	}

	public long getTotal_amount() {
		return Total_amount;
	}

	public void setTotal_amount(long total_amount) {
		Total_amount = total_amount;
	}

	public long getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(long paid_amount) {
		this.paid_amount = paid_amount;
	}

	public long getNext_installment() {
		return next_installment;
	}

	public void setNext_installment(long next_installment) {
		this.next_installment = next_installment;
	}

	public LocalDate getPossesion_Date() {
		return possesion_Date;
	}

	public void setPossesion_Date(LocalDate possesion_Date) {
		this.possesion_Date = possesion_Date;
	}

	public String getUsr_Password() {
		return usr_Password;
	}

	public void setUsr_Password(String usr_Password) {
		this.usr_Password = usr_Password;
	}

	public List<VisitBook> getvBook() {
		return vBook;
	}

	public void setvBook(List<VisitBook> vBook) {
		this.vBook = vBook;
	}

	
	

	
	
	

}
