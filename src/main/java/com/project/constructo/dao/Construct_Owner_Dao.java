package com.project.constructo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.Updates;
@Repository
public class Construct_Owner_Dao {

	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public boolean add_Constr_Owner(ConstructOwner constr) {
		try {
			
			entityManager.merge(constr);
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	@Transactional
	public ConstructOwner checkConstr(ConstructOwner constr) {
		System.out.println("User : "+constr.getUsrName());
		try {
			
			return (ConstructOwner) entityManager.createQuery("select t from  ConstructOwner t where t.usrName=:temp and t.c_Password=:temp2").setParameter("temp", constr.getUsrName()).setParameter("temp2", constr.getC_Password()).getSingleResult();

			
			
		}catch(Exception e) {
			
			
			return null;
		}
	
		
	}
	
	@Transactional
	public ConstructOwner findByEmailId(String email) {
		try {
			
			return (ConstructOwner) entityManager.createQuery("select t from  ConstructOwner t where t.email=:temp").setParameter("temp", email).getSingleResult();

			
			
		}catch(Exception e) {
			
			
			return null;
		}
	
		
	}
	@Transactional
	public boolean constr_updates(Updates update) {
		
		try {
			
			 entityManager.merge(update);
			
				return true;
			
			
		}catch(Exception e ) {
			
			e.printStackTrace();
			return false;
		}
	}
	
}
