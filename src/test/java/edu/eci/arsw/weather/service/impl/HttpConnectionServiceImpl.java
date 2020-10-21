package edu.eci.arsw.weather.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.service.IHttpConnectionService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HttpConnectionServiceImpl implements IHttpConnectionService {
    @Override
    public JSONObject getWeatherByCity(String name) throws UnirestException {
        HttpResponse<String> response = Unirest
                .get("https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=aa765dc9488fb2a128d6730d1d1c6e1e")
                .asString();
        return new JSONObject(response.getBody());
    }
}
