package com.airafrika.controllers.airlineServlet;

import com.airafrika.entities.Airline;
import com.airafrika.services.AirlineService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAirlineServlet", urlPatterns = {"/update-airline"})
public class UpdateAirlineServlet extends HttpServlet {
    private AirlineService airlineService = new AirlineService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String airlineIdStr = request.getParameter("id");

        if (airlineIdStr != null && !airlineIdStr.isEmpty()) {
            int airlineId = Integer.parseInt(airlineIdStr);
             Airline airline = airlineService.getAirlineById(airlineId);

            if (airline != null) {
                request.setAttribute("airline", airline);
                request.getRequestDispatcher("admin/airline/editAirline.jsp").forward(request, response);
            } else {
                response.sendRedirect("airlinesList");
            }
        } else {
            response.sendRedirect("airlinesList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle the form submission to update airline information
        String airlineIdStr = request.getParameter("id");
        String updatedName = request.getParameter("name");
        String updatedDescription = request.getParameter("description");

        if (airlineIdStr != null && !airlineIdStr.isEmpty()) {
            int airlineId = Integer.parseInt(airlineIdStr);
            // Update the airline information in the database
            airlineService.updateAirline(airlineId, updatedName, updatedDescription);
            response.sendRedirect("airlinesList");
        } else {
            response.sendRedirect("airlinesList");
        }
    }
}
