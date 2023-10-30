package com.airafrika.services;

import com.airafrika.dao.AirlineDAO;
import com.airafrika.dao.FlightDAO;
import com.airafrika.entities.Airline;
import com.airafrika.entities.Flight;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class FlightService {
    FlightDAO flightDAO = new FlightDAO();

    public Flight addFlight(Flight flight) {
        FlightDAO flightDAO = new FlightDAO();
        flightDAO.createFlight(flight);
        return flight;
    }
    public List<Flight> getAllFlights(){

        return flightDAO.getAllFlights();
    }

    public void deleteFlight(int flightId) {
        Flight flight = getFlightById(flightId);
        if (flight != null) {
            flightDAO.deleteFlight(flight.getId());
        }
    }

    public Flight getFlightById(int flightId){
       Flight flight= flightDAO.getFlightById(flightId);
        return (flight);

    }

    public Flight updateFlight(Flight flight) {
        return flightDAO.updateFlight(flight);
    }


}
