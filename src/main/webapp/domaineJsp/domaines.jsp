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
	<h1>Domaines:</h1>

<!-- Affichage de la liste des domaines -->
<c:forEach var="domaine" items="${domaines}">
    <!-- Affichage des informations sur chaque domaine -->
    <p>
        <strong>ID:</strong> <c:out value="${domaine.id}" /><br>
        <strong>Nom:</strong> <c:out value="${domaine.nom}" /><br>
        <strong>Description:</strong> <c:out value="${domaine.description}" /><br>
        <strong>Critères:</strong> <c:out value="${domaine.criteres}" /><br>

        <!-- Bouton pour modifier le domaine -->
        <a href="DomaineServlet?action=modifier&id=${domaine.id}" class="button">Modifier</a>

        <!-- Bouton pour supprimer le domaine -->
        <a href="DomaineServlet?action=supprimer&id=${domaine.id}" class="button" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce domaine ?');">Supprimer</a>
    </p>
</c:forEach>

<!-- Lien vers la page d'ajout d'un domaine -->
<a href="DomaineServlet?action=ajouter" class="button">Ajouter un Domaine</a>

</body>
</html>