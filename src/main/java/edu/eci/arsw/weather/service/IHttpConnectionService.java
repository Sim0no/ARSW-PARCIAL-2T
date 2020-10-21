package edu.eci.arsw.weather.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public interface IHttpConnectionService {
    public JSONObject getWeatherByCity(String name) throws UnirestException;
}
