function initPage() {
	//calling IP API and parsing to JSON
	var locatie_json = JSON.parse(getApi("https://ipapi.co/json/"));

	//altering HTML with JSON data
	document.querySelector("#code").innerHTML = locatie_json.country;
	document.querySelector("#land").innerHTML = locatie_json.country_name;
	document.querySelector("#regio").innerHTML = locatie_json.region;
	document.querySelector("#stad").innerHTML = locatie_json.city;
	document.querySelector("#postcode").innerHTML = locatie_json.postal;
	document.querySelector("#lat").innerHTML = locatie_json.latitude;
	document.querySelector("#long").innerHTML = locatie_json.longitude;
	document.querySelector("#ip").innerHTML = locatie_json.ip;
	
	
	//call showWeather with the coordinates and city of IP API as parameters
	showWeather(Math.round(locatie_json.latitude),Math.round(locatie_json.longitude),locatie_json.city);
	
	//call holiday API
	loadCountries();
}

function showWeather(lat, lon, city) {
	
	//adds city name to the title
	document.querySelector("#weathertitle").innerHTML = "Het weer in " + city;
	
	//creating the API URL for weather with coordinates of IP API
	var openWeatherMapKey = "b6fefe26a5fbcecadba51b447c9df7d7"
	var weatherUrl = ("http://api.openweathermap.org/data/2.5/weather?lat="
			+ lat + "&lon="
			+ lon + "&APPID=" + openWeatherMapKey);
	console.log(weatherUrl);
	
	//Parsing API response to JSON
	var weather_json = JSON.parse(getApi(weatherUrl));
	console.log(weather_json.main.temp);
	
	//alters HTML with weather JSON data
	document.querySelector("#temp").innerHTML = toCelsius(weather_json.main.temp).toString().substring(0,4)+ " C";
	document.querySelector("#lucht").innerHTML = weather_json.main.humidity;
	document.querySelector("#wind").innerHTML = weather_json.wind.speed;
	document.querySelector("#windr").innerHTML = degToCard(weather_json.wind.deg);
	var d = new Date(0);
	d.setUTCSeconds(weather_json.sys.sunrise)
	document.querySelector("#op").innerHTML = d.toString().substring(15,24);
	var d2 = new Date(0);
	d2.setUTCSeconds(weather_json.sys.sunset)
	document.querySelector("#onder").innerHTML = d2.toString().substring(15,24);
}

//Gets API responses with the URL as parameter
function getApi(yourUrl) {

	var Httpreq = new XMLHttpRequest();
	Httpreq.open("GET", yourUrl, false);
	Httpreq.send(null);
	return Httpreq.responseText;

}

//Converts Kelvins to Celsius
function toCelsius(kelvin) {
	if (kelvin < (0)) {
		return 'below absolute zero (0 K)';
	} else {
		return (kelvin-273.15);
	}
}

//converts degree to abbreviation
var degToCard = function(deg){
	  if (deg>11.25 && deg<33.75){
	    return "NNE";
	  }else if (deg>33.75 && deg<56.25){
	    return "ENE";
	  }else if (deg>56.25 && deg<78.75){
	    return "E";
	  }else if (deg>78.75 && deg<101.25){
	    return "ESE";
	  }else if (deg>101.25 && deg<123.75){
	    return "ESE";
	  }else if (deg>123.75 && deg<146.25){
	    return "SE";
	  }else if (deg>146.25 && deg<168.75){
	    return "SSE";
	  }else if (deg>168.75 && deg<191.25){
	    return "S";
	  }else if (deg>191.25 && deg<213.75){
	    return "SSW";
	  }else if (deg>213.75 && deg<236.25){
	    return "SW";
	  }else if (deg>236.25 && deg<258.75){
	    return "WSW";
	  }else if (deg>258.75 && deg<281.25){
	    return "W";
	  }else if (deg>281.25 && deg<303.75){
	    return "WNW";
	  }else if (deg>303.75 && deg<326.25){
	    return "NW";
	  }else if (deg>326.25 && deg<348.75){
	    return "NNW";
	  }else{
	    return "N"; 
	  }
	}

//fill the holiday table
function loadCountries() {
	
	//parse JSON
	var countries_json = JSON.parse(getApi("restservices/countries"));
	console.log(countries_json);
	
	for (let x = 0; countries_json.length > x; x++) {
		
		 var tableRow = document.createElement("tr");


         var Land = document.createElement("td");
         var Hoofdstad = document.createElement("td");
         var Regio = document.createElement("td");
         var Oppervlakte = document.createElement("td");
         var Inwoners = document.createElement("td");
         var actions = document.createElement("td");

         Land.innerText = countries_json[x]["name"];
         Hoofdstad.innerText = countries_json[x]["capital"];
         Regio.innerText = countries_json[x]["region"];
         Oppervlakte.innerText = countries_json[x]["surface"];
         Inwoners.innerText = countries_json[x]["population"];
         var lat = countries_json[x].latitude;
         var lon = countries_json[x]["longitude"];
         tableRow.appendChild(Land);
         tableRow.appendChild(Hoofdstad);
         tableRow.appendChild(Regio);
         tableRow.appendChild(Oppervlakte);
         tableRow.appendChild(Inwoners);
         
         tableRow.addEventListener('click', function(){
        	 showWeather(countries_json[x].latitude,countries_json[x]["longitude"],countries_json[x]["capital"])
         });
         
         table.appendChild(tableRow);
	}	
	}

function differentLoc() {
	
}

initPage();