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
    <h1>Modifier un Feedback</h1>

<form action="FeedbackServlet?action=save&id=${feedback.id}" method="post">
    <label for="message">Message :</label>
    <input type="text" id="message" name="message" value="${feedback.message}" required><br><br>

    <label for="proposition">Proposition :</label>
    <input type="text" id="proposition" name="proposition" value="${feedback.proposition}" required><br><br>

    <label for="projet_id">Projet :</label>
    <select id="projet_id" name="projet_id" required>
        <c:forEach var="projet" items="${projets}">
            <option value="${projet.id}" <c:if test="${projet.id == feedback.projet.id}">selected</c:if>>${projet.titre}</option>
        </c:forEach>
    </select><br><br>

    <label for="habitant_id">Habitant :</label>
    <select id="habitant_id" name="habitant_id" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}" <c:if test="${habitant.id == feedback.habitant.id}">selected</c:if>>${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">save</button>
</form>
    
</body>
</html>