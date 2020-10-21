package edu.eci.arsw.weather.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.City;
import edu.eci.arsw.weather.service.IWeatherStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class WeatherStatsController {
    @Autowired
    private IWeatherStatsService weatherStatsS;
    @GetMapping("/weather/{cityName}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable String cityName){
        try{
            City data = weatherStatsS.getStatsByCity(cityName);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (UnirestException e){
            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
