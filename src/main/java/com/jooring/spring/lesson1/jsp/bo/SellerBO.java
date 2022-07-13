package com.jooring.spring.lesson1.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.spring.lesson1.jsp.dao.SellerDAO;
import com.jooring.spring.lesson1.jsp.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, String profileImageUrl, double temperature) {
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}

	//Controller는 최대한 간단하고 명료하게, 복잡하면 BO에다 해도 돼 ~
	
	public Seller getSeller(Integer id) {
		
		if(id == null) {
			return sellerDAO.selectLastUser();
		}else {
			
		 return sellerDAO.selectSeller(id);
		}
	}
}
