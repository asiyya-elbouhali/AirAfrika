package com.airafrika.controllers.flightServlet;

import com.airafrika.services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( urlPatterns = {"/delete-flight"})
public class DeleteFlightServlet extends HttpServlet {
    FlightService flightService = new FlightService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("id");

        if (flightIdStr != null && !flightIdStr.isEmpty()) {
            int flightId = Integer.parseInt(flightIdStr);
            flightService.deleteFlight(flightId);
        }
        response.sendRedirect("flights");
    }


}
