<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 23/10/2023
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Update Airline</title>
</head>
<body class="bg-gray-100">
<div class="flex h-screen">
    <aside class="w-1/6 bg-blue-500 text-white p-4">
        <h2 class="text-2xl font-bold mb-4">AirAfrika Dashboard</h2>
        <ul>
            <li class="mb-2">
                <a href="airlines?action=list" class="block py-2 px-4 rounded hover:bg-blue-600">Airline</a>
            </li>
            <li>
                <a href="flight" class="block py-2 px-4 rounded hover-bg-blue-600">Flight</a>
            </li>
        </ul>
    </aside>
    <main class="w-5/6 p-8 overflow-y-auto">
        <h1 class="text-2xl font-bold mb-4">Update Airline</h1>
        <form action="update-airline" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${airline.id}">
            <div class="mb-4">
                <label for="name" class="block text-gray-600">Airline Name</label>
                <input type="text" id="name" name="name" value="${airline.name}" class="w-full px-3 py-2 border border-gray-300 rounded">
            </div>
            <div class="mb-4">
                <label for="description" class="block text-gray-600">Airline Description</label>
                <textarea id="description" name="description" class="w-full px-3 py-2 border border-gray-300 rounded">${airline.description}</textarea>
            </div>
            <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">Update Airline</button>
        </form>
    </main>
</div>
</body>
</html>

