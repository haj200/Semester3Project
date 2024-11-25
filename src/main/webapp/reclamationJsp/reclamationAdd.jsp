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
 <h1>Ajouter Un Projet</h1>
<form action="ProjetServlet?action=save" method="POST" enctype="multipart/form-data">
    <label for="titre">Titre:</label>
    <input type="text" id="titre" name="titre" required><br><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br><br>

    <label for="objectifs">Objectifs:</label>
    <input type="text" id="objectifs" name="objectifs" required><br><br>

    <label for="budget">Budget:</label>
    <input type="number" id="budget" name="budget" required><br><br>

    <label for="documentsJustif">Documents justificatifs:</label>
    <input type="file" id="documentsJustif" name="documentsJustif"><br><br>

    <label for="localisation">Localisation:</label>
    <input type="text" id="localisation" name="localisation" required><br><br>

    <label for="benefice">Bénéfice:</label>
    <input type="text" id="benefice" name="benefice" required><br><br>

    <label for="estValide">Est validé:</label>
    <input type="checkbox" id="estValide" name="estValide"><br><br>

    <label for="gain">Gain:</label>
    <input type="number" id="gain" name="gain" required><br><br>

    <!-- Liste des Habitants -->
    <label for="habitants">Habitant:</label>
    <select id="habitants" name="habitants" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}">${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <!-- Liste des Domaines -->
    <label for="domaines">Domaine:</label>
    <select id="domaines" name="domaines" required>
        <c:forEach var="domaine" items="${domaines}">
            <option value="${domaine.id}">${domaine.nom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Ajouter Projet</button>
</form>

      
</body>
</html>