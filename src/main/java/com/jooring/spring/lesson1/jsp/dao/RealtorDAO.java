package com.jooring.spring.lesson1.jsp.dao;

import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.jsp.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public int insertRealtor(Realtor realtor);

	
}
