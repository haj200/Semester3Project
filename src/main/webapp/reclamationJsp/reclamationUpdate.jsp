<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>Modifier une Réclamation</h1>



<form action="ReclamationServlet?action=modifier&id=${reclamation.id}" method="post">
    <label for="message">Message :</label>
    <input type="text" id="message" name="message" value="${reclamation.message}" required><br><br>

    <label for="habitant_id">Habitant :</label>
    <select id="habitant_id" name="habitant_id" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}" <c:if test="${habitant.id == reclamation.habitant.id}">selected</c:if>>${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">save</button>
</form>

       
</body>
</html>