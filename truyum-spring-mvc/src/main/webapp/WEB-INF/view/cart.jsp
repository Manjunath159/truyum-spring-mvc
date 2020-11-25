<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cart</h1>


	<table>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach var="menuItem" items="${cartItems}">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:choose>
						<c:when test="${menuItem.freeDelivery}">
									Yes
								</c:when>
						<c:otherwise>
									No
								</c:otherwise>
					</c:choose></td>
				<td>${menuItem.price}</td>
				<td><a
					href="/remove-cart?menuItemId=${menuItem.id}&userId=${userId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>Total</td>
			<td>${total}</td>
		</tr>
	</table>

</body>
</html>