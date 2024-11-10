<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>domaines</title>
</head>
<body>
	<h1> Domaines:</h1>
	<c:forEach var="domaine" items="${domaines}">
        
    <!-- Affichage du domaine -->
    <c:out value="${domaine.id}" />
    <c:out value="${domaine.nom}" />
    <c:out value="${domaine.description}" />
    <c:out value="${domaine.criteres}" />

</c:forEach>
	
</body>
</html>