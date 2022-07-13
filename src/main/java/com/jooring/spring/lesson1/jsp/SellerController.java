package com.jooring.spring.lesson1.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.spring.lesson1.jsp.bo.SellerBO;
import com.jooring.spring.lesson1.jsp.model.Seller;
@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;
	
	@ResponseBody
	@RequestMapping(value="/insert", method=RequestMethod.POST)
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
	
	
	@GetMapping("/info")
	public String sellerInfo(@RequestParam(value="id", required=false)Integer id
			,Model model){
		
			
		Seller seller = sellerBO.getSeller(id);
				
		
		model.addAttribute("result", seller);	
		return "jsp/sellerInfo";
		
	}
	

	
	

}
