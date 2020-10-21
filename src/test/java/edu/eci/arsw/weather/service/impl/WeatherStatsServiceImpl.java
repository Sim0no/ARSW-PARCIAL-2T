package edu.eci.arsw.weather.service.impl;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.*;
import edu.eci.arsw.weather.service.IHttpConnectionService;
import edu.eci.arsw.weather.service.IWeatherStatsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherStatsServiceImpl implements IWeatherStatsService {

    @Autowired
    private IHttpConnectionService weatherS;
    @Override
    public City getStatsByCity(String name) throws UnirestException {

        City cityWeather = new City();
        JSONObject object = weatherS.getWeatherByCity(name);
        Coordinates crd = formatObject("coord",object,Coordinates.class);
        Clouds cloud = formatObject("clouds",object,Clouds.class);
        Stats stats = formatObject("main",object,Stats.class);
        JSONObject weatherJ = object.getJSONArray("weather").getJSONObject(0);
        Weather weather = mapWeather(weatherJ);
        Wind wind = formatObject("wind",object,Wind.class);
        setCityWeatherStats(cityWeather,crd,wind,cloud,object,weather,stats);
        return cityWeather;
    }

    private Weather mapWeather(JSONObject objectWeater) {
        Gson gson = new Gson();
        return gson.fromJson(objectWeater.toString(),Weather.class);
    }
    private <T> T formatObject(String objectName, JSONObject object, Class objectClass){
        Gson g = new Gson();
        String stringObject =  object.getJSONObject(objectName).toString();
        T formattedObject = (T) g.fromJson(stringObject,objectClass);
        return formattedObject;
    }
    private void setCityWeatherStats(City cityWeather,Coordinates coord,Wind wind, Clouds clouds, JSONObject object, Weather weather, Stats mainStats) {
        cityWeather.setCoord(coord);
        cityWeather.setWeather(weather);
        cityWeather.setMainStats(mainStats);
        cityWeather.setClouds(clouds);
        cityWeather.setWind(wind);
        cityWeather.setName(object.getString("name"));
        cityWeather.setTimezone(object.getInt("timezone"));
        cityWeather.setCod(object.getInt("cod"));
        cityWeather.setVisibility(object.getInt("visibility"));

    }
}
