package com.jooring.spring.lesson1.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.spring.lesson1.mybatis.bo.RealEstateBO;
import com.jooring.spring.lesson1.mybatis.model.RealEstate;

@Controller
public class RealEstateController {
	
	//id가 5인 real_estate 행 json으로 response출력
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/1")
	public RealEstate realEstate(@RequestParam(value="id",defaultValue="1")int id) {
		RealEstate realEstate =realEstateBO.getRealEstate(id);
		
		return realEstate;
		
	}
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/2")
	public List<RealEstate> realEstate2(@RequestParam(value="rent",defaultValue="90")int rent) {
		List<RealEstate> realEstate = realEstateBO.getRealEstate2(rent);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/3")
	public List<RealEstate> RealEstate3(@RequestParam(value="area",defaultValue="10")int area, 
			@RequestParam(value="price", defaultValue="1000000")int price){
		
		List<RealEstate> list = realEstateBO.getRealEstate3(area, price);
		
		return list;
		
	} 
	/*
	
	
*/	
}
