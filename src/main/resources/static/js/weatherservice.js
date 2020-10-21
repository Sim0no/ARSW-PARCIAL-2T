const weatherservice = (() =>{
    const getWeatherByCity = (city,callback) =>{
        axios.get('/weather/' + city).then(res=>{
            callback(res);
        })
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();const weatherservice = (() =>{
    const getWeatherByCity = (city,callback) =>{
        axios.get('/weather/' + city).then(res=>{
            callback(res);
        })
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();