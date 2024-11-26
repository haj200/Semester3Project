<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>habitants</title>
</head>
<body>
hello


    <h1>Habitants:</h1>

<!-- Affichage de la liste des habitants -->
<c:forEach var="habitant" items="${habitants}">
    <!-- Affichage des informations sur chaque habitant -->
    <p>
        <strong>ID:</strong> <c:out value="${habitant.id}" /><br>
        <strong>Username:</strong> <c:out value="${habitant.username}" /><br>
        <strong>Nom:</strong> <c:out value="${habitant.nom}" /><br>
        <strong>Prénom:</strong> <c:out value="${habitant.prenom}" /><br>
        <strong>Email:</strong> <c:out value="${habitant.email}" /><br>
        <strong>CIN:</strong> <c:out value="${habitant.cin}" /><br>
        <strong>Adresse:</strong> <c:out value="${habitant.addresse}" /><br>
        <strong>Date de Naissance:</strong> <c:out value="${habitant.dateDeNaissance}" /><br>
        <strong>Métier:</strong> <c:out value="${habitant.metier}" /><br>

        <!-- Bouton pour modifier l'habitant -->
        <a href="HabitantServlet?action=modifier&id=${habitant.id}" class="button">Modifier</a>

        <!-- Bouton pour supprimer l'habitant -->
        <a href="HabitantServlet?action=supprimer&id=${habitant.id}" class="button" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet habitant ?');">Supprimer</a>
    </p>
</c:forEach>

<!-- Lien vers la page d'ajout d'un habitant -->
<a href="HabitantServlet?action=ajouter" class="button">Ajouter un Habitant</a>


</body>
</html>