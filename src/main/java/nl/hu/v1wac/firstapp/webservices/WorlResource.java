package nl.hu.v1wac.firstapp.webservices;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/countries")
public class WorlResource {

	@GET
	@Produces("application/json")
	public String getAll() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.getAllCountries()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("latitude", c.getLatitude());
			job.add("longitude", c.getLongitude());

			jab.add(job);
		}

		JsonArray array = jab.build();

		return array.toString();

	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public String getByCode(@PathParam("id") String id) {
		
		WorldService service = ServiceProvider.getWorldService();
		
		Country result = service.getCountryByCode(id);
		
			
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", result.getCode());
			job.add("iso3", result.getIso3());
			job.add("name", result.getName());
			job.add("capital", result.getCapital());
			job.add("continent", result.getContinent());
			job.add("region", result.getRegion());
			job.add("surface", result.getSurface());
			job.add("population", result.getPopulation());
			job.add("government", result.getGovernment());
			job.add("latitude", result.getLatitude());
			job.add("longitude", result.getLongitude());
	
		
	
		JsonObject country = job.build();

		return country.toString();

	}

	@GET
	@Path("largestsurfaces")
	@Produces("application/json")
	public String getBySurface() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.get10LargestSurfaces()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("latitude", c.getLatitude());
			job.add("longitude", c.getLongitude());

			jab.add(job);
		}

		JsonArray array = jab.build();

		return array.toString();
		
	}
	
	@GET
	@Path("largestpopulations")
	@Produces("application/json")
	public String getByPopulation() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.get10LargestPopulations()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("latitude", c.getLatitude());
			job.add("longitude", c.getLongitude());

			jab.add(job);
		}

		JsonArray array = jab.build();

		return array.toString();
		
	}
}
