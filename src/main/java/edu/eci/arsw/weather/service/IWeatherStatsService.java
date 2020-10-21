package edu.eci.arsw.weather.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.City;

public interface IWeatherStatsService {
    City getStatsByCity(String name) throws UnirestException;

}
