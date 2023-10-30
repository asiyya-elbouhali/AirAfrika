package com.airafrika.controllers.flightServlet;

import com.airafrika.entities.Airline;
import com.airafrika.entities.Flight;
import com.airafrika.services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = {"/update-flight" })
public class UpdateFlightServlet extends HttpServlet {
    FlightService flightService= new FlightService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("id");

        if (flightIdStr != null && !flightIdStr.isEmpty()) {
            int flightId = Integer.parseInt(flightIdStr);
            Flight flight = flightService.getFlightById(flightId);

            if (flight != null) {
                request.setAttribute("flight", flight);
                request.getRequestDispatcher("admin/flight/editflight.jsp").forward(request, response);
            } else {
                response.sendRedirect("flights");
            }
        } else {
            response.sendRedirect("flights");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("id");
        String updatedFlightNumber = request.getParameter("flightNumber");
        String updatedDepartureCity = request.getParameter("departureCity");
        String updatedArrivalCity = request.getParameter("arrivalCity");
        String updatedDepartureTime = request.getParameter("departureTime");
        String updatedArrivalTime = request.getParameter("arrivalTime");
        String updatedDateDeparture = request.getParameter("dateDeparture");
        String updatedDateArrival = request.getParameter("dateArrival");
        int updatedAvailableSeats = Integer.parseInt(request.getParameter("availableSeats"));
        double updatedTarifMad = Double.parseDouble(request.getParameter("tarifMad"));
        double updatedTarifEuro = Double.parseDouble(request.getParameter("tarifEuro"));
        boolean updatedStopover = Boolean.parseBoolean(request.getParameter("stopover"));

        if (flightIdStr != null && !flightIdStr.isEmpty()) {
            int flightId = Integer.parseInt(flightIdStr);
            Flight flight = flightService.getFlightById(flightId);

            if (flight != null) {
                // Update the flight properties
                flight.setFlightNumber(updatedFlightNumber);
                flight.setDepartureCity(updatedDepartureCity);
                flight.setArrivalCity(updatedArrivalCity);
                flight.setDepartureTime(updatedDepartureTime);
                flight.setArrivalTime(updatedArrivalTime);
                flight.setDateDeparture(updatedDateDeparture);
                flight.setDateArrival(updatedDateArrival);
                flight.setAvailableSeats(updatedAvailableSeats);
                flight.setTarifMad(updatedTarifMad);
                flight.setTarifEuro(updatedTarifEuro);
                flight.setStopover(updatedStopover);

                // Update the flight in the database
                flightService.updateFlight(flight);

                response.sendRedirect("flights"); // Redirect to the flights page after updating the flight
            } else {
                response.sendRedirect("flights");
            }
        } else {
            response.sendRedirect("flights");
        }
    }
 }
