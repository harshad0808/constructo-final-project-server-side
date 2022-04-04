package com.project.constructo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class FlatCount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long count_id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Construct_id")
	ConstructOwner owner;
	
	@Column
	private int count;

	public long getCount_id() {
		return count_id;
	}

	public void setCount_id(long count_id) {
		this.count_id = count_id;
	}

	public ConstructOwner getOwner() {
		return owner;
	}

	public void setOwner(ConstructOwner owner) {
		this.owner = owner;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
