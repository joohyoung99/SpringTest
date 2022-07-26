package com.jooring.spring.lesson1.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.spring.lesson1.ajax.dao.FavoriteDAO;
import com.jooring.spring.lesson1.ajax.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public int addFavorite(String name, String url) {
		
		return favoriteDAO.insertFavorite(name, url);
		
	}	
	public List<Favorite> getFavorite(){
		return favoriteDAO.selectFavoriteList();
	
		
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = favoriteDAO.selectCountByUrl(url);
		
		if(count == 0) {
			return false;
		}else {
			return true;
		}
		
		
		//return count!= 0;
		
		//return favoriteDAO.selectCountByUrl(url) != 0;
	}
	
	public int deleteId(int id) {
		
		 return favoriteDAO.deleteId(id);
	}

}
