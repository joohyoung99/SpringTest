package com.jooring.spring.lesson1.jstl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jooring.spring.lesson1.jstl.model.Weatherhistory;

@Repository
public interface WeatherDAO {
	
	public List<Weatherhistory> selectWeather();

	
	public Weatherhistory insertWeather(@Param("date")Date date
			,@Param("weather") String weather
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation 
			,@Param("microDust") String microDust
			,@Param("windSpeed") double windSpeed);
	
}


