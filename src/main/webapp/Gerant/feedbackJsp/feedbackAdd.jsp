<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Ajouter un Feedback</h1>
<form action="FeedbackServlet?action=save" method="POST">
    <!-- Message du feedback -->
    <label for="message">Message :</label>
    <textarea id="message" name="message" required></textarea><br><br>

    <!-- Proposition du feedback -->
    <label for="proposition">Proposition :</label>
    <textarea id="proposition" name="proposition" required></textarea><br><br>

    <!-- Liste des Projets -->
    <label for="projet_id">Projet :</label>
    <select id="projet_id" name="projet_id" required>
        <c:forEach var="projet" items="${projets}">
            <option value="${projet.id}">${projet.titre}</option>
        </c:forEach>
    </select><br><br>

    <!-- Liste des Habitants -->
    <label for="habitant_id">Habitant :</label>
    <select id="habitant_id" name="habitant_id" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}">${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">save</button>
</form>
    
</body>
</html>