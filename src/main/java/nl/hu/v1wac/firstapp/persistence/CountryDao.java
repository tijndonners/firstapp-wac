package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;
import java.util.List;

import nl.hu.v1wac.firstapp.webservices.Country;

public interface CountryDao {
	
    public boolean save(Country Country);
    
    public boolean update(Country Country);
    
    public boolean delete(Country Country);

	public List<Country> findAll();

	public Country findByCode(String code);

	public List<Country> find10LargestPopulations();

	public List<Country> find10LargestSurfaces();
    
    
}
