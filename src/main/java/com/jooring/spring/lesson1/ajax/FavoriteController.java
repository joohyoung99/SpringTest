package com.jooring.spring.lesson1.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.spring.lesson1.ajax.bo.FavoriteBO;
import com.jooring.spring.lesson1.ajax.model.Favorite;
@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

	@Autowired
	private FavoriteBO favoriteBO;
	
	@PostMapping("/insert")
	@ResponseBody
	public Map<String,String> addFavorite(
			@RequestParam("name") String name
			,@RequestParam("url") String url) {
		
		int count = favoriteBO.addFavorite(name, url);
		
		Map<String,String> result = new HashMap<>();
		
		
		if(count == 1) {
			
			result.put("result","success");
			
		
		}else {
			
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		List<Favorite> favoriteList = favoriteBO.getFavorite();
		
		
		model.addAttribute("favorite",favoriteList);
		return "ajax/favoriteList";
	}
	@GetMapping("/input")
	public String FavoriteInput() {
		
		return "ajax/favoriteInsert";
	}
	
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicate(@RequestParam("url") String name) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(favoriteBO.isDuplicateUrl(name)) {
			//중복된 상태
			result.put("is_duplicate", true);
		}else {
			//중복되지 않은 상태
			result.put("is_duplicate", false);
		}
		
		// result.put("is_duplicate", favoriteBO.isDuplicateName(url));
		
		return result;
	}
	
	public deleteUrl(@RequestParam("url") String url) {
		
		
	}
	
	
}
