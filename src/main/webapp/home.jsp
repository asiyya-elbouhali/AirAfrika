<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <script src="https://cdn.tailwindcss.com"></script>
  <title>Flight Search Results</title>
</head>
<body class="bg-gray-100">
<div class="flex h-screen">
  <!-- Sidebar -->
  <aside class="w-1/6 bg-blue-500 text-white p-4">
    <h2 class="text-2xl font-bold mb-4">AirAfrika Dashboard</h2>
    <ul>
      <li class="mb-2">
        <a href="airlinesList" class="block py-2 px-4 rounded hover:bg-blue-600">Airline</a>
      </li>
      <li>
        <a href="flights" class="block py-2 px-4 rounded hover:bg-blue-600">Flight</a>
      </li>
    </ul>
  </aside>

  <main class="w-5/6 p-8 overflow-y-auto">
    <div class="flex flex-wrap p-4">
      <c:if test="${not empty flights}">
        <c:forEach items="${flights}" var="flight">
          <div class="w-1/4 p-4">
            <div class="bg-white rounded-lg shadow-md p-4">
              <img src="https://picsum.photos/200/300?random=2">
              <h2 class="text-lg font-bold">${flight.airline.name}</h2>
              <p class="text-gray-600">
                <span class="font-bold">from</span>

              ${flight.departureCity}
                <br>
                <span class="font-bold">to</span>
              ${flight.arrivalCity}</p>
              <p class="text-gray-600">
                <span class="font-bold">Departure Date:</span>
                  ${flight.dateDeparture}
                <br>
                    <span class="font-bold">Arrival Date:</span>
                      ${flight.dateArrival}</p>
              <p class="text-green-600 font-bold text-xl">${flight.tarifMad} MAD</p>
              <a href="${flight.id}" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded mt-2 block text-center">Details</a>
            </div>
          </div>
        </c:forEach>
      </c:if>
    </div>
  </main>
</div>
</body>
</html>
