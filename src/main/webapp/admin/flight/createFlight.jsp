<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 23/10/2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>

    <title>Title</title>
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
                <a href="flights" class="block py-2 px-4 rounded hover-bg-blue-600">Flight</a>
            </li>
        </ul>
    </aside>

    <main class="w-5/6 p-8 overflow-y-auto">
        <h1 class="text-3xl font-bold mb-4">Create Flight</h1>

    <form action="${pageContext.request.contextPath}/add-flight" method="post" class="w-full max-w-lg">
        <div class="mb-4">
            <label for="flightNumber" class="block text-gray-600">Flight Number:</label>
            <input type="text" id="flightNumber" name="flightNumber" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="departureCity" class="block text-gray-600">Departure City:</label>
            <input type="text" id="departureCity" name="departureCity" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="arrivalCity" class="block text-gray-600">Arrival City:</label>
            <input type="text" id="arrivalCity" name="arrivalCity" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="departureTime" class="block text-gray-600">Departure Time:</label>
            <input type="time" id="departureTime" name="departureTime" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="arrivalTime" class="block text-gray-600">Arrival Time:</label>
            <input type="time" id="arrivalTime" name="arrivalTime" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="dateDeparture" class="block text-gray-600">Date of Departure:</label>
            <input type="date" id="dateDeparture" name="dateDeparture" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="dateArrival" class="block text-gray-600">Date of Arrival:</label>
            <input type="date" id="dateArrival" name="dateArrival" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="availableSeats" class="block text-gray-600">Available Seats:</label>
            <input type="number" id="availableSeats" name="availableSeats" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="tarifMad" class="block text-gray-600">Tarif (MAD):</label>
            <input type="number" step="0.01" id="tarifMad" name="tarifMad" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="tarifEuro" class="block text-gray-600">Tarif (Euro):</label>
            <input type="number" step="0.01" id="tarifEuro" name="tarifEuro" required class="w-full border rounded px-3 py-2">
        </div>

        <div class="mb-4">
            <label for="stopover" class="block text-gray-600">Stopover:</label>
            <input type="checkbox" id="stopover" name="stopover" class="form-checkbox">
        </div>

        <h1 class="text-2xl font-bold mb-4">Select Airline</h1>
        <div class="mb-4">
            <label for="airlineSelection" class="block text-gray-600">Choose an Airline:</label>
            <select id="airlineSelection" name="selectedAirline" class="w-full border rounded px-3 py-2">
                <c:forEach items="${airlines}" var="airline">
                    <option value="${airline.id}">${airline.name}</option>
                </c:forEach>

            </select>
        </div>

        <div class="mt-4 mb-10">
            <input type="submit" value="Create Flight" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded hover:bg-blue-600">
        </div>
    </form>
    </main>
</div>
</body>
</html>
