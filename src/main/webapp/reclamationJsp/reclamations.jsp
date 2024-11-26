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
   <h1>Réclamations :</h1>

<!-- Affichage de la liste des réclamations -->
<c:forEach var="reclamation" items="${reclamations}">
    <!-- Affichage des informations sur chaque réclamation -->
    <p>
        <strong>ID :</strong> <c:out value="${reclamation.id}" /><br>
        <strong>Message :</strong> <c:out value="${reclamation.message}" /><br>
        
        <strong>Habitant :</strong> <c:out value="${reclamation.habitant.nom} ${reclamation.habitant.prenom}" /><br>

        <!-- Bouton pour modifier la réclamation -->
        <a href="ReclamationServlet?action=modifier&id=${reclamation.id}" class="button">Modifier</a>

        <!-- Bouton pour supprimer la réclamation -->
        <a href="ReclamationServlet?action=supprimer&id=${reclamation.id}" class="button" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette réclamation ?');">Supprimer</a>
    </p>
</c:forEach>

<!-- Lien vers la page d'ajout d'une réclamation -->
<a href="ReclamationServlet?action=ajouter" class="button">Ajouter une Réclamation</a>

   
</body>
</html>