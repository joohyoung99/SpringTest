package com.jooring.spring.lesson1.database.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.database.model.Store;

@Repository
public interface StoreDAO {

	
	public List<Store> selectStoreList();
}
