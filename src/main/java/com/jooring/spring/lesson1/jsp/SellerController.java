package com.jooring.spring.lesson1.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jooring.spring.lesson1.jsp.bo.SellerBO;
@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;
	
	@PostMapping("/insert")
	public String addSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam(value="image", required=false)String profileImageUrl
			, @RequestParam("temperature")double temperature) {
		
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "삽입결과: " + count;
	}
	
	@GetMapping("/input_view")
	public String sellerInputView() {
		
		return "jsp/sellerInput";
	}
	
	

}
