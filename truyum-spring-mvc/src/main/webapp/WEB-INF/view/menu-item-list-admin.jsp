<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table {
	font-family: arial, sans-serif;
}

td, th {
	text-align: left;
	padding: 8px;
}

nav {
	display: block;
	top: 0;
	background-color: #34558f;
}

li {
	display: inline;
}
</style>


</head>
<body>

	<nav>
		<h2>truyum</h2>
		<ul>
			<li><a href="# menu-item-list-admin.html">Menu</a></li>
			<li><a href="# cart.html">cart</a></li>
	</nav>
	<p>Menu Items</p>
	<table>
		<tr>
			<th>Name</th>
			<th>price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>free delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${menuItemListAdmin}">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.active}</td>
				<td>${item.dateOfLaunch}</td>
				<td>${item.category}</td>
				<td>${item.freeDelivery}</td>
				<td><a href="/show-edit-menu-item?menuItemId=${item.id}">Edit</a></td>
			</tr>

		</c:forEach>


	</table>

</body>
</html>
