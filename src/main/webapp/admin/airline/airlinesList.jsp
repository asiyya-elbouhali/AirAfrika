<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 24/10/2023
  Time: 00:03
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
    <h1 class="text-2xl font-bold mb-4">Airline Management</h1>
     <a href="${pageContext.request.contextPath}/admin/airline/createAirline.jsp" class="block py-2 px-4 rounded hover:bg-blue-600">Add a New Airline</a>

     <table class="w-full border border-collapse">
      <thead class="bg-blue-500 text-white">
      <tr>
        <th class="py-2 px-4">Airline Name</th>
        <th class="py-2 px-4">Airline Description</th>
        <th class="py-2 px-4">Actions</th>
      </tr>
      </thead>
      <tbody>
       <c:forEach items="${airlines}" var="airline">
        <tr class="border-t">
          <td class="py-2 px-4">${airline.name}</td>
          <td class="py-2 px-4">${airline.description}</td>

          <td class="py-2 px-4">
            <a href="${pageContext.request.contextPath}/update-airline?id=${airline.id}" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">Update</a>
            <a href="${pageContext.request.contextPath}/delete-airline?id=${airline.id}" class="bg-red-500 text-white py-2 px-4 rounded hover:bg-red-600 ml-2 hover:text-white">Delete</a>        </tr>
      </c:forEach>
      </tbody>
    </table>
  </main>
</div>
</body>
</html>
