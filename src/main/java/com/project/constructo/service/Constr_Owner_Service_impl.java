package com.project.constructo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.constructo.dao.Construct_Owner_Dao;
import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatOwner;
import com.project.constructo.model.Updates;
import com.project.constructo.repository.UpdateRepo;

@Service
public class Constr_Owner_Service_impl implements Constr_Owner_Service_inf {
	
	@Autowired
	private Construct_Owner_Dao constrDao;
	
	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	private UpdateRepo updateRepo;

	@Override
	public boolean register(ConstructOwner constr_obj) {
		
		try {
			
			
			return constrDao.add_Constr_Owner(constr_obj);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}

	
	@Override
	public List<FlatOwner> fetch_Owners() {
		
		//Pending...................
		
		return null;
	}


	@Override
	public boolean isExist(ConstructOwner constr) {

		ConstructOwner obj = constrDao.checkConstr(constr);
		if(obj!=null)
		return false;
		else
			return true;
	}


	@Override
	public boolean addUpdate(Updates update) {

		try {
			if(update != null)
			{
				return constrDao.constr_updates(update);
			}else {
				return false;
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			return false;
		}

		
		
	}

	public int validateEmailAndGenearateOtp(String email) {
		int randomNumber;
		System.out.println("in serv");
		if (constrDao.findByEmailId(email)!=null) {
			randomNumber = (int) (Math.random() * 9999);
			if (randomNumber <= 1000) {
				randomNumber = randomNumber + 1000;
			}
			emailService.sendMail(email,"OTP password Reset",String.valueOf(randomNumber));
			return randomNumber;
		}
		else {
			return -1;
		}
	}
	
	
	public boolean changePassword(String email, String password) {
		ConstructOwner u=constrDao.findByEmailId(email);//.or Else Throw();
		u.setC_Password(password);
		
			
		return constrDao.add_Constr_Owner(u);
	}
	public List<Updates> fetchImage(long c_id) {
		System.out.println("C-ID: -----------------"+c_id);
		return updateRepo.findById(c_id);
	} 
		
}
