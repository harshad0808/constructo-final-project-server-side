package com.project.constructo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.project.constructo.model.ConstructOwner;
import com.project.constructo.model.FlatCount;
import com.project.constructo.model.FlatOwner;

@Component("LocalDao")
public class LocalDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public ConstructOwner verifyLogin(String username,String Password)
	{
		try
		{
			System.out.println("inside dao");
		return (ConstructOwner) entityManager.createQuery("select t from  ConstructOwner t where t.usrName=:temp and t.c_Password=:temp2").setParameter("temp", username).setParameter("temp2", Password).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public FlatCount getCount(long construct_id)
	{
		try
		{
			System.out.println("inside dao");
		return (FlatCount) entityManager.createQuery("select t from  FlatCount t where t.owner.c_id=:temp").setParameter("temp", construct_id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public ConstructOwner getConstructOwnerByUsername(String username)
	{
		try
		{
			System.out.println("inside dao");
		return (ConstructOwner) entityManager.createQuery("select t from  ConstructOwner t where t.usrName=:temp").setParameter("temp", username).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public FlatOwner verifyLoginFlat(int key,String Password)
	{
		try
		{
			System.out.println("inside dao");
		return (FlatOwner) entityManager.createQuery("select t from  FlatOwner t where t.usr_Key=:temp and t.usr_Password=:temp2").setParameter("temp", key).setParameter("temp2", Password).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public FlatOwner validateAccount(int key)
	{
		try
		{
			System.out.println("inside dao");
		return (FlatOwner) entityManager.createQuery("select t from FlatOwner t where t.usr_Key=:temp").setParameter("temp", key).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
