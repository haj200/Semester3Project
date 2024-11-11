<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reclamations</title>
</head>
<body>
   <h1>Liste des reclamations</h1>
   <c:forEach var="reclamation" items="${reclamations}">
    
    <!-- Affichage des détails de la réclamation -->
    <c:out value="${reclamation.id}" />
    <c:out value="${reclamation.message}" />
    <c:out value="${reclamation.reponse}" />
    
    <!-- Affichage des informations de l'habitant lié à la réclamation -->
    <c:out value="${reclamation.habitant.nom}" />
    <c:out value="${reclamation.habitant.prenom}" />
    
</c:forEach>
   
</body>
</html>