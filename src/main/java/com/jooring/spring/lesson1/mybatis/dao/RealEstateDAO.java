package com.jooring.spring.lesson1.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	//id가 5인 realestate 전달
	public RealEstate selectRealEstate(@Param("id")int id);

	
	public List<RealEstate> selectRealEstate2(@Param("rent") int rent);



	public List<RealEstate> selectRealEstate3(@Param("area")int area,@Param("price") int price);



}
