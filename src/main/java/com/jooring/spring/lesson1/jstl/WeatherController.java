package com.jooring.spring.lesson1.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jooring.spring.lesson1.jstl.bo.WeatherBO;
import com.jooring.spring.lesson1.jstl.model.Weatherhistory;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/jstl/weather/list")
	public String weatherList(Model model) {
		
		List<Weatherhistory> weatherHistory =weatherBO.getWeather();
		model.addAttribute("weather",weatherHistory);
		 
		return"jstl/test05";
	}
	
	@GetMapping("/jstl/insert_view")
	public String addWeather(
			@DateTimeFormat(pattern="yyyy년 MM월 dd일")
			@RequestParam("date") Date date,
			@RequestParam("weather") String weather
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitation") double precipitation
			,@RequestParam("microDust") String microDust
			,@RequestParam("windSpeed")double windSpeed
			) {
		
		int count = weatherBO.addWeather(date,weather,temperatures,precipitation,microDust,windSpeed);
		
		
		return "redirect:/jsp/test05";
	
	}
	
	
	@GetMapping("/jstl/input_view")
	public String inputWeather() {
		return "jstl/insertWeather";
	}

}
