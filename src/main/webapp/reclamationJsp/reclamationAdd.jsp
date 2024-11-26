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
 <h1>Ajouter Une Réclamation</h1>
<form action="ReclamationServlet?action=save" method="POST">
    <!-- Message de la réclamation -->
    <label for="message">Message :</label>
    <textarea id="message" name="message" required></textarea><br><br>

    <!-- Réponse à la réclamation -->
    

    <!-- Liste des Habitants -->
    <label for="habitants">Habitant :</label>
    <select id="habitants" name="habitants" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}">${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">save</button>
</form>

      
</body>
</html>