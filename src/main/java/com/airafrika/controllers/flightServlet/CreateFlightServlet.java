package com.airafrika.controllers.flightServlet;

import com.airafrika.entities.Airline;
import com.airafrika.entities.Flight;
import com.airafrika.services.AirlineService;
import com.airafrika.services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/add-flight","/flight" })
public class CreateFlightServlet extends HttpServlet {
    FlightService flightService= new FlightService();
    AirlineService airlineService = new AirlineService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        String dateDeparture = request.getParameter("dateDeparture");
        String dateArrival = request.getParameter("dateArrival");
        int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
        String tarifMad = request.getParameter("tarifMad");
        String tarifEuro = request.getParameter("tarifEuro");
        String stopover = request.getParameter("stopover");
        String airlineSelectionStr = request.getParameter("selectedAirline");
        int airlineSelection = 0;
        if (airlineSelectionStr != null && !airlineSelectionStr.isEmpty()) {
            airlineSelection = Integer.parseInt(airlineSelectionStr);
        }
        AirlineService airlineService = new AirlineService();
        Airline selectedAirline = airlineService.getAirlineById(airlineSelection);

        Flight flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setDepartureCity(departureCity);
        flight.setArrivalCity(arrivalCity);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setDateDeparture(dateDeparture);
        flight.setDateArrival(dateArrival);
        flight.setAvailableSeats(availableSeats);
        flight.setTarifMad(Double.valueOf(tarifMad));
        flight.setTarifEuro(Double.valueOf(tarifEuro));
        flight.setStopover(Boolean.parseBoolean(stopover));
        flight.setAirline(selectedAirline);
        System.out.println("this if selectedAirline");
        System.out.println(selectedAirline);
         flightService.addFlight(flight);
          response.sendRedirect("/flights");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("airlines", airlineService.getAllAirlines());
        request.getRequestDispatcher("/admin/flight/createFlight.jsp").forward(request, response);
    }




}
