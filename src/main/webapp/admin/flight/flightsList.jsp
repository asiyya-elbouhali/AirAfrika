<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 25/10/2023
  Time: 14:59
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
                <a href="flights" class="block py-2 px-4 rounded hover:bg-blue-600">Flight</a>
            </li>
        </ul>
    </aside>

    <main class="w-5/6 p-8 overflow-y-auto">
        <h1 class="text-2xl font-bold mb-4">Flight Management</h1>
        <a href="${pageContext.request.contextPath}/add-flight" class="block py-2 px-4 rounded hover:bg-blue-600">Add a New Flight</a>

        <table class="w-full border border-collapse">
            <thead class="bg-blue-500 text-white">
            <tr>
                <th class="py-2 px-4">Departure City</th>
                <th class="py-2 px-4">Arrival City</th>
                <th class="py-2 px-4">Departure time</th>
                <th class="py-2 px-4">Arrival time</th>
                <th class="py-2 px-4">Departure Date</th>
                <th class="py-2 px-4">Arrival Date</th>
                <th class="py-2 px-4">Available seats</th>
                <th class="py-2 px-4">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${flights}" var="flight">
                <tr class="border-t text-sm">
                    <td class="py-2 px-4">${flight.departureCity}</td>
                    <td class="py-2 px-4">${flight.arrivalCity}</td>
                    <td class="py-2 px-4">${flight.departureTime}</td>
                    <td class="py-2 px-4">${flight.arrivalTime}</td>
                    <td class="py-2 px-4">${flight.dateDeparture}</td>
                    <td class="py-2 px-4">${flight.dateArrival}</td>
                    <td class="py-2 px-4">${flight.availableSeats}</td>

                    <td class="py-2 px-4   flex">
                        <a href="${pageContext.request.contextPath}/update-flight?id=${flight.id}" class="bg-blue-500 text-white py-2 px-4 mr-2 rounded hover:bg-blue-600">Update</a>
                        <a href="${pageContext.request.contextPath}/delete-flight?id=${flight.id}" class="bg-red-500 text-white py-2 px-4 rounded hover:bg-red-600   hover:text-white  ">Delete</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
</body>
</html>
