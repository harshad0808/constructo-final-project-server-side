package com.project.constructo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component("LocalDao")
public class LocalDao {
	@PersistenceContext
	protected EntityManager entityManager;

}
