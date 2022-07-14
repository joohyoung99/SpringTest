package com.jooring.spring.lesson1.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.spring.lesson1.jsp.dao.RealtorDAO;
import com.jooring.spring.lesson1.jsp.model.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorDAO realtorDAO;
	
	public int addRealtor(Realtor realtor) {
		
	 return	realtorDAO.insertRealtor(realtor);
		
	}
	
	
}
