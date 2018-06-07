package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.firstapp.webservices.Country;

public class CountryDaoPostgreslmpl extends PostgresBaseDao implements CountryDao{

	@Override
	public boolean save(Country Country) {
		try (Connection connection = getConnection()) {


            PreparedStatement stmt = connection.prepareStatement("INSERT INTO COUNTRY (code, iso3, name, capital, continent, region, surfacearea, population, governmentform, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, Country.getCode());
            stmt.setString(2, Country.getIso3());
            stmt.setString(3, Country.getName());
            stmt.setString(4, Country.getCapital());
            stmt.setString(5, Country.getContinent());
            stmt.setString(6, Country.getRegion());
            stmt.setDouble(7, Country.getSurface());
            stmt.setInt(8, Country.getPopulation());
            stmt.setString(9, Country.getGovernment());
            stmt.setDouble(10, Country.getLatitude());
            stmt.setDouble(11, Country.getLongitude());

            return stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null != null;

    }

		


	 @Override
	    public boolean update(Country country) {
	        try (Connection connection = getConnection()) {


	            PreparedStatement stmt = connection.prepareStatement("UPDATE COUNTRY SET POPULATION = ? WHERE CODE = ?");
	            stmt.setInt(1, country.getPopulation());
	            stmt.setString(2, country.getCode());
	            return stmt.execute();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	        return null != null;
	    }

	    @Override
	    public boolean delete(Country country) {

	        try (Connection connection = getConnection()) {


	            PreparedStatement stmt = connection.prepareStatement("DELETE FROM COUNTRY WHERE CODE = ?");
	            stmt.setString(1, country.getCode());
	            return stmt.execute();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	        return null != null;

	    }
	
	@Override
    public List<Country> findAll() {

        try (Connection connection = getConnection()) {


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COUNTRY");

            ArrayList<Country> countries = new ArrayList<>();

            while (rs.next()) {

                Country c = new Country(
                        rs.getString("code"),
                        rs.getString("iso3"),
                        rs.getString("name"),
                        rs.getString("capital"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getDouble("surfacearea"),
                        rs.getInt("population"),
                        rs.getString("governmentform"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );

                countries.add(c);

            }

            return countries;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
	
    @Override
    public Country findByCode(String code) {

        try (Connection connection = getConnection()) {


            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COUNTRY WHERE CODE = ?");
            stmt.setString(1, code);

            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {

                Country c = new Country(
                        rs.getString("code"),
                        rs.getString("iso3"),
                        rs.getString("name"),
                        rs.getString("capital"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getDouble("surfacearea"),
                        rs.getInt("population"),
                        rs.getString("governmentform"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );

                return c;

            }




        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }
    
    @Override
    public List<Country> find10LargestPopulations() {
        try (Connection connection = getConnection()) {


            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COUNTRY ORDER BY POPULATION DESC LIMIT 10");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Country> countries = new ArrayList<>();

            while (rs.next()) {

                Country c = new Country(
                        rs.getString("code"),
                        rs.getString("iso3"),
                        rs.getString("name"),
                        rs.getString("capital"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getDouble("surfacearea"),
                        rs.getInt("population"),
                        rs.getString("governmentform"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );

                countries.add(c);

            }

            return countries;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Country> find10LargestSurfaces() {
        try (Connection connection = getConnection()) {


            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COUNTRY ORDER BY SURFACEAREA DESC LIMIT 10");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Country> countries = new ArrayList<>();

            while (rs.next()) {

                Country c = new Country(
                        rs.getString("code"),
                        rs.getString("iso3"),
                        rs.getString("name"),
                        rs.getString("capital"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getDouble("surfacearea"),
                        rs.getInt("population"),
                        rs.getString("governmentform"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );

                countries.add(c);

            }

            return countries;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
