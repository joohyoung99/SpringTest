package com.jooring.spring.lesson1.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.spring.lesson1.database.bo.StoreBO;
import com.jooring.spring.lesson1.database.model.Store;

@Controller
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;
	
	@ResponseBody
	@RequestMapping("/database/test01/1")
	public List<Store> test01(){
		
		List<Store> list = storeBO.getStoreList();
		
		return list;
	}

}
