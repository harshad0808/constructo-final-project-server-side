package com.project.constructo.model;

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
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="ConstructOwner")
public class ConstructOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long c_id;
	
	@Column
	private String C_Name;
	
	@Column
	private String usrName;
	
	@Column
	private String address;
	
	@Column
	private String rera_No;
	
	@Column
	private int no_Flats;
	
	@Column
	private String verify_Status;
	
	@Column
	private String email;
	
	@Column
	private String phone_No;
	
	@Column
	private String c_Password;
	
	
	
	 @JsonIgnore
	@OneToMany (mappedBy = "cOwner")
	private List <FlatOwner> fOwner;
	 @JsonIgnore
	@OneToMany (mappedBy = "cOwnerUpdate")
	private List <Updates> update;
	 
	 @JsonIgnore
		@OneToMany(mappedBy = "consowner")
		private List <VisitBook> visitBook;
	
	public ConstructOwner() {
		
	}

	public ConstructOwner(long c_id, String c_Name, String usrName, String address, String rera_No, int no_Flats,
			String verify_Status, String email, String phone_No, String c_Password, List<FlatOwner> fOwner,
			List<Updates> update) {
		this.c_id = c_id;
		C_Name = c_Name;
		this.usrName = usrName;
		this.address = address;
		this.rera_No = rera_No;
		this.no_Flats = no_Flats;
		this.verify_Status = verify_Status;
		this.email = email;
		this.phone_No = phone_No;
		this.c_Password = c_Password;
		this.fOwner = fOwner;
		this.update = update;
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getC_Name() {
		return C_Name;
	}

	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRera_No() {
		return rera_No;
	}

	public void setRera_No(String rera_No) {
		this.rera_No = rera_No;
	}

	public int getNo_Flats() {
		return no_Flats;
	}

	public void setNo_Flats(int no_Flats) {
		this.no_Flats = no_Flats;
	}

	public String getVerify_Status() {
		return verify_Status;
	}

	public void setVerify_Status(String verify_Status) {
		this.verify_Status = verify_Status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public String getC_Password() {
		return c_Password;
	}

	public void setC_Password(String c_Password) {
		this.c_Password = c_Password;
	}

	public List<FlatOwner> getfOwner() {
		return fOwner;
	}

	public void setfOwner(List<FlatOwner> fOwner) {
		this.fOwner = fOwner;
	}

	public List<Updates> getUpdate() {
		return update;
	}

	public void setUpdate(List<Updates> update) {
		this.update = update;
	}

	

}
