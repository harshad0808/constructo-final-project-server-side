package com.project.constructo.service;

import java.util.List;

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatOwner;
import com.project.constructo.model.Updates;

public interface Constr_Owner_Service_inf {
public boolean register(ConstructOwner constr_obj);
	
	public List<FlatOwner> fetch_Owners();
	
	public boolean isExist(ConstructOwner obj);
	
	public boolean addUpdate(Updates update);
	
}
