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
    <h1>Feedbacks :</h1>

<!-- Affichage de la liste des feedbacks -->
<c:forEach var="feedback" items="${feedbacks}">
    <!-- Affichage des informations sur chaque feedback -->
    <p>
        <strong>ID :</strong> <c:out value="${feedback.id}" /><br>
        <strong>Message :</strong> <c:out value="${feedback.message}" /><br>
        <strong>Proposition :</strong> <c:out value="${feedback.proposition}" /><br>
        <strong>Projet :</strong> <c:out value="${feedback.projet.titre}" /><br>
        <strong>Habitant :</strong> <c:out value="${feedback.habitant.nom} ${feedback.habitant.prenom}" /><br>
	<!-- Bouton pour modifier le feedback -->
        <a href="FeedbackServlet?action=modifier&id=${feedback.id}" class="button">Modifier</a>

        <!-- Bouton pour supprimer le feedback -->
        <a href="FeedbackServlet?action=supprimer&id=${feedback.id}" class="button" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce feedback ?');">Supprimer</a>
        
    </p>
    
</c:forEach>

<!-- Lien vers la page d'ajout d'un feedback -->
<a href="FeedbackServlet?action=ajouter" class="button">Ajouter un Feedback</a>
    
</body>
</html>