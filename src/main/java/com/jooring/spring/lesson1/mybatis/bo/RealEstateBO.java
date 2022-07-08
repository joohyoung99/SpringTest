package com.jooring.spring.lesson1.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.spring.lesson1.mybatis.dao.RealEstateDAO;
import com.jooring.spring.lesson1.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	//id가 5인 real_Estate 정보 전달 
	@Autowired
	private RealEstateDAO realEstateDAO;

	public RealEstate getRealEstate(int id) {
	RealEstate realEstate =	realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	
	public List<RealEstate> getRealEstate2(int rent) {
		List<RealEstate> realEstate = realEstateDAO.selectRealEstate2(rent); 
		return realEstate;
	}
	
	public List<RealEstate> getRealEstate3(int area, int price){
		List<RealEstate> list = realEstateDAO.selectRealEstate3(area,price);
	
		return list;
	}

}
