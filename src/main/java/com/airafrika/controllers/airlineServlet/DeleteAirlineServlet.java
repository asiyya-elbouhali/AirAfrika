package com.airafrika.controllers.airlineServlet;

import com.airafrika.services.AirlineService; // Import your service class
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/delete-airline"})
public class DeleteAirlineServlet extends HttpServlet {
    AirlineService airlineService = new AirlineService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String airlineIdStr = request.getParameter("id");

        if (airlineIdStr != null && !airlineIdStr.isEmpty()) {
            int airlineId = Integer.parseInt(airlineIdStr);
            airlineService.deleteAirline(airlineId);
        }
         response.sendRedirect("airlinesList");
    }
}

