<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admins</title>
</head>
<body>
<h1>Admins:</h1>
<!-- Affichage de la liste des admins -->
<c:forEach var="admin" items="${admins}">
    <!-- Affichage des informations sur chaque admin -->
    <p>
        <strong>ID:</strong> <c:out value="${admin.id}" /><br>
        <strong>Nom:</strong> <c:out value="${admin.nom}" /><br>
        <strong>Nom:</strong> <c:out value="${admin.prenom}" /><br>
        <strong>Description:</strong> <c:out value="${admin.username}" /><br>
        <strong>Critères:</strong> <c:out value="${admin.email}" /><br>
        

        <!-- Bouton pour modifier le admin -->
        <a href="AdministrateurServlet?action=modifier&id=${admin.id}" class="button">Modifier</a>

        <!-- Bouton pour supprimer le admin -->
        <a href="AdministrateurServlet?action=supprimer&id=${admin.id}" class="button" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce admin ?');">Supprimer</a>
    </p>
</c:forEach>

<!-- Lien vers la page d'ajout d'un admin -->
<a href="AdministrateurServlet?action=ajouter" class="button">Ajouter un admin</a>
</body>
</html>