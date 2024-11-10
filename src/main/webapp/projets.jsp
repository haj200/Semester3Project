<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Projets</h1>
<c:forEach var="projet" items="${projets}">
        
    <!-- Affichage des détails du projet -->
    <c:out value="${projet.id}" />
    <c:out value="${projet.titre}" />
    <c:out value="${projet.description}" />
    <c:out value="${projet.objectifs}" />
    <c:out value="${projet.budget}" />
    <c:out value="${projet.documentsJustif}" />
    <c:out value="${projet.localisation}" />
    <c:out value="${projet.benefice}" />
    <c:out value="${projet.estValide}" />
    <c:out value="${projet.gain}" />
    
    <!-- Affichage des informations de l'habitant lié au projet -->
    <c:out value="${projet.habitant.nom}" />
    <c:out value="${projet.habitant.prenom}" />
    
    <!-- Affichage du domaine lié au projet -->
    <c:out value="${projet.domaine.nom}" />
    
</c:forEach>

</body>
</html>