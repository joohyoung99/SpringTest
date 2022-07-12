package com.jooring.spring.lesson1.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDAO {
	
	public int insertSeller(
			@Param("nickname")String nickname
			, @Param("image")String profileImageUrl
			, @Param("temperature")double temperature);

}
