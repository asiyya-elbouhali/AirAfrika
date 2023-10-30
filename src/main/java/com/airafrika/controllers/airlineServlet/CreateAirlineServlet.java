package com.airafrika.controllers.airlineServlet;

import com.airafrika.entities.Airline;
import com.airafrika.services.AirlineService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "airlineServlet", urlPatterns = {"/add-airline", "/airlinesList" })
public class CreateAirlineServlet extends HttpServlet {
      AirlineService airlineService = new AirlineService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Airline airline = new Airline();
        airline.setName(name);
        airline.setDescription(description);
         airlineService.addAirline(airline);
         response.sendRedirect("/airlinesList");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("airlines", airlineService.getAllAirlines());
        System.out.println(airlineService.getAllAirlines());
        request.getRequestDispatcher("admin/airline/airlinesList.jsp").forward(request, response);
    }



}
