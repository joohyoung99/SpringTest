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


	public int insertRealEstateByObject(RealEstate realEstate);
	
	
	public int insertRealEstate(@Param("realtorId") int realtorId
			,@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			,@Param("rentPrice") int rentPrice);

	public int updateRealEstate(@Param("id")int id
			,@Param("type") String type
			,@Param("price") int price);
	
	
	public int deleteRealEstate(@Param("id")int id);
}
