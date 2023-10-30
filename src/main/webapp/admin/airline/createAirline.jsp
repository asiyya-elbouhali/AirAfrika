<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 23/10/2023
  Time: 18:37
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
    <aside class="w-1/6 bg-blue-500 text-white p-4">
        <h2 class="text-2xl font-bold mb-4">AirAfrika Dashboard</h2>
        <ul>
            <li class="mb-2">
                <a href="/airlinesList" class="block py-2 px-4 rounded hover:bg-blue-600">Airline</a>
            </li>
            <li>
                <a href="/flights" class="block py-2 px-4 rounded hover-bg-blue-600">Flight</a>
            </li>
        </ul>
    </aside>
    <main class="w-5/6 p-8 overflow-y-auto">
    <h1 class="text-3xl font-bold mt-8">Welcome to AirAfrika!</h1>
    <p class="text-gray-600">Explore our flights, make reservations, and enjoy a hassle-free travel experience.</p>

    <form action="/add-airline" method="post" class="mt-8">
        <label for="name" class="block text-gray-600 mb-2">Airline Name:</label>
        <input type="text" id="name" name="name" required class="w-full border rounded px-3 py-2 mb-4">

        <label for="description" class="block text-gray-600 mb-2">Description:</label>
        <textarea id="description" name="description" required class="w-full border rounded px-3 py-2 mb-4"></textarea>

        <div class="mt-4">
            <input type="submit" value="Add Airline" class="bg-blue-500 text-white font-semibold py-2 px-4 rounded hover:bg-blue-600">
        </div>
    </form>
    <a href="../../../airlinesList" class="block py-2 px-4 rounded hover:bg-blue-600">Back to Airlines List</a>
</section>
    </main>
</div>
</body>
</html>
