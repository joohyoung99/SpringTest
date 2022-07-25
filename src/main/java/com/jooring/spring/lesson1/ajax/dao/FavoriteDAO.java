package com.jooring.spring.lesson1.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.ajax.model.Favorite;

@Repository
public interface FavoriteDAO {
	
	public int insertFavorite(@Param("name") String name
			,@Param("url")String url);
	
	public List<Favorite> selectFavoriteList();

	
	//name 
	//select count(1) from `new_user` where `name` = 'joo';
	public int selectCountByUrl(@Param("url") String url);

	
	public int deleteUrl(@Param("url") String url);
}
