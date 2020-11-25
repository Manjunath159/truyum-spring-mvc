<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
h2{
color:green;}
</style>


</head>
<body>

	<nav>
		<h2>truyum</h2>
		<ul>
			<li><a href=" menu-item-list-admin.html">Menu</a></li>
			<li><a href=" cart.html">cart</a></li>
	</nav>
	<c:set var="addedCart" scope="session" value="${addCartStatus}"/>
			<c:if test="${addedCart == true}">
				<h2>Item added to cart Successfully</h2>
			</c:if>
	<p>Menu Items</p>
	<table>
		<tr>
			<th>Name</th>
			<th>free delivery</th>
			<th>price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${menuItemListCustomer}">
			<tr>
				<td>${item.name}</td>
				<td>${item.freeDelivery}</td>
				<td>${item.price}</td>
				<td>${item.category}</td>
				<td><a href="/add-to-cart?menuItemId=${item.id}">Add to
						Cart</a></td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>