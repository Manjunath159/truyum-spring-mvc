<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<style>
nav {
	display: block;
	top: 0;
	background-color: #34558f;
}

li {
	display: inline;
}

.button {
	color: white;
	padding: 15px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	background-color: #008CBA;
}
</style>
</head>
<body>
	<nav>
		<h2>truyum</h2>
		<ul>
			<li><a href="menu-item-list-admin.html">Menu</a></li>
			<li><a href="cart.html">cart</a></li>
	</nav>
	<p>Edit Menu item</p>
	<form name="menuItemForm" method="POST" action="edit-menu-item">

		<label for="title">Name</label><br> <input type="text" id="title"
			value="${menuItem.name}" required><br> <br> <br>
		<label for="price">Price(Rs.)</label><br> <input type="number"
			id="price" value="${menuItem.price}" required> &nbsp; &nbsp;
		&nbsp; <label>Active</label> <input type="radio"
			<c:if test="${menuItem.active}">checked</c:if> value="Yes" />Yes<input
			type="radio" <c:if test="${not menuItem.active}">checked</c:if>
			value="No" />No &nbsp; &nbsp; <label for="dateoflaunch">Date
			of Launch</label> <input type="text" id="dateoflaunch"
			value="${menuItem.dateOfLaunch}"> &nbsp; &nbsp; &nbsp; <label>Category</label>
		<select id="category"> <
			<c:forEach var="a" items="${categoryList}">
				<option value="${a}">${a}</option>
			</c:forEach>
			<br>
			<br>
			<label>Free Delivery</label>
			<input type="checkbox"
			value="${menuItem.freeDelivery}"  <c:if test="${menuItem.freeDelivery}">checked</c:if>> <br> <br>

		<div id="button">
			<input type="submit" value="Save">
		</div>


	</form>
</body>
</html>

