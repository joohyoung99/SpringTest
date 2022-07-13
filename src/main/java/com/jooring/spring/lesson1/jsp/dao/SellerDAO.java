package com.jooring.spring.lesson1.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.jsp.model.Seller;

@Repository
public interface SellerDAO {
	
	public int insertSeller(
			@Param("nickname")String nickname
			, @Param("image")String profileImageUrl
			, @Param("temperature")double temperature);

	
	public Seller selectLastUser();
	
	public Seller selectSeller(@Param("id")int id);
}
