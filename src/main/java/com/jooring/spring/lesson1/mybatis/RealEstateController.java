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
@RequestMapping("/mybatis")
public class RealEstateController {
	
	//id가 5인 real_estate 행 json으로 response출력
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@ResponseBody
	@RequestMapping("/test01/1")
	public RealEstate realEstate(@RequestParam(value="id",defaultValue="1")int id) {
		RealEstate realEstate =realEstateBO.getRealEstate(id);
		
		return realEstate;
		
	}
	
	@ResponseBody
	@RequestMapping("/test01/2")
	public List<RealEstate> realEstate2(@RequestParam(value="rent",defaultValue="90")int rent) {
		List<RealEstate> realEstate = realEstateBO.getRealEstate2(rent);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("/test01/3")
	public List<RealEstate> RealEstate3(@RequestParam(value="area",defaultValue="10")int area, 
			@RequestParam(value="price", defaultValue="1000000")int price){
		
		List<RealEstate> list = realEstateBO.getRealEstate3(area, price);
		
		return list;
		
	} 
	
	@ResponseBody
	@RequestMapping("/test02/1")
	public String addRealEstateByObject() {
		
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		return "삽입 결과: " + count;
	
	
	}
	
	@ResponseBody
	@RequestMapping("/test02/2")
	public String addRealEstate(@RequestParam(value="realtorId") int realtorId) {
		
		int count = realEstateBO.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "삽입 결과: " + count;
	
	}
	
	@ResponseBody
	@RequestMapping("/test03/1")
	public String updateRealEstate() {
		int count = realEstateBO.updateRealEstate(10, "전세", 70000);
		return "수정 성공: " + count;
	}
	
	@ResponseBody
	@RequestMapping("/test04/1")
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = realEstateBO.deleteRealEstate(id);
		return "삭제 성공: " + count;
	}
}
