<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cinema</title>
</head>
<body>
 <fmt:setLocale value = "fr_FR"/>
<h2>Votre cadyy</h2>
<a href="ShowAllFilms">Home</a>
<table>
	<tr><th>Titre</th><th>Prix HT</th></tr>
	<c:forEach items="${caddy.films }" var="film">
		<tr>
			<td>${film.titre }</td>
			<td><fmt:formatNumber value = "${film.prixHT}" type = "currency"/></td>
<%-- 			<td><a href="DelFilmFromCaddy?id=${film.id}">supprimer</a></td> --%>
			<td><a href="ChangeCaddy?cd=min&id=${film.id }">-</a>
				${caddy.quantity(film) }
				<a href="ChangeCaddy?cd=plus&id=${film.id }">+</a></td>
		</tr>
	</c:forEach>
	<tr><th colspan="1">Total</th><th><fmt:formatNumber value = "${caddy.prixTotalHT}" type = "currency"/></th></tr>
</table>
</body>
</html>