package com.airafrika.controllers.flightServlet;

import com.airafrika.services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = { "/flights","/"})
public class FlightsListServlet extends HttpServlet {
    FlightService flightService = new FlightService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/flights":
                    getAllFlights(request, response);
                    break;
                case "/":
                    getAllHomeFlights(request, response);
                    break;

                default:
                    System.out.println("choice not found");
                    break;
            }
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }


    private void getAllFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("flights", flightService.getAllFlights());
        request.getRequestDispatcher("/admin/flight/flightsList.jsp").forward(request, response);
    }

    private void getAllHomeFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("flights", flightService.getAllFlights());
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }










}
