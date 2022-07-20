package com.jooring.spring.lesson1.jstl.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.spring.lesson1.jstl.dao.WeatherDAO;
import com.jooring.spring.lesson1.jstl.model.Weatherhistory;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weatherhistory> getWeather() {
		
		return weatherDAO.selectWeather();
	}
	
	public Weatherhistory addWeather(Date date, String weather,double temperatures, double precipitation, String microDust, double windSpeed ) {
		return weatherDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
	}

}
