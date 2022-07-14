package com.jooring.spring.lesson1.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jooring.spring.lesson1.jsp.bo.RealtorBO;
import com.jooring.spring.lesson1.jsp.model.Realtor;
@RequestMapping("/jsp/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorBO realtorBO;
	
	@PostMapping("/insert_view")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		int count = realtorBO.addRealtor(realtor);
		
		model.addAttribute("result", realtor);
		return "jsp/realtorInfo";
		
	}
	
	
	@GetMapping("/input_view")
	public String InsertRealtor() {
		return "jsp/realtorInput";
	}
	
	

}
