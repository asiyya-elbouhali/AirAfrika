package com.airafrika.services;

import com.airafrika.dao.AirlineDAO;
import com.airafrika.entities.Airline;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AirlineService {

    AirlineDAO airlineDAO = new AirlineDAO();


    public Airline addAirline(Airline airline) {
         airlineDAO.createAirline(airline);
        return airline;
    }

    public List<Airline> getAllAirlines(){
        return airlineDAO.getAllAirlines();
    }

    public Airline getAirlineById(int airlineId) {
         Airline airline = airlineDAO.getAirlineById(airlineId);
        return airline;
    }
    public Airline updateAirline(Airline airline) {
         return airlineDAO.updateAirline(airline);
    }

    public void deleteAirline(int airlineId) {
        Airline airline = getAirlineById(airlineId);
        if (airline != null) {
            airlineDAO.deleteAirline(airline.getId());
        }
    }

    public void updateAirline(int airlineId, String updatedName, String updatedDescription) {
        Airline existingAirline = airlineDAO.getAirlineById(airlineId);

        if (existingAirline != null) {
             existingAirline.setName(updatedName);
            existingAirline.setDescription(updatedDescription);

             airlineDAO.updateAirline(existingAirline);
        }
    }

}
