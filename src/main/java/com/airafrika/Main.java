package com.airafrika;

import com.airafrika.dao.AirlineDAO;
import com.airafrika.entities.Airline;
import com.airafrika.services.AirlineService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("thiiiiiiiis");
        AirlineService airlineDAO = new AirlineService();
        List<Airline> airlines = airlineDAO.getAllAirlines();

        for (Airline airline : airlines) {
            System.out.println(airline);
        }
    }

}
