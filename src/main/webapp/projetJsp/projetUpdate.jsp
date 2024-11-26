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
    <h1>Modifier un Projet</h1>

<form action="ProjectServlet?action=save&id=${projet.id}" method="post">

    <label for="titre">Titre :</label>
    <input type="text" id="titre" name="titre" value="${projet.titre}" required><br><br>

    <label for="description">Description :</label>
    <input type="text" id="description" name="description" value="${projet.description}" required><br><br>

    <label for="objectifs">Objectifs :</label>
    <input type="text" id="objectifs" name="objectifs" value="${projet.objectifs}" required><br><br>

    <label for="budget">Budget :</label>
    <input type="number" step="0.01" id="budget" name="budget" value="${projet.budget}" required><br><br>

    <label for="localisation">Localisation :</label>
    <input type="text" id="localisation" name="localisation" value="${projet.localisation}" required><br><br>

    <label for="benefice">Bénéfice :</label>
    <input type="text" id="benefice" name="benefice" value="${projet.benefice}" required><br><br>

    <label for="gain">Gain :</label>
    <input type="number" step="0.01" id="gain" name="gain" value="${projet.gain}" required><br><br>

    <!-- Sélection de l'Habitant -->
    <label for="habitant_id">Habitant :</label>
    <select id="habitant_id" name="id_habitant" required>
        <c:forEach var="habitant" items="${habitants}">
            <option value="${habitant.id}" <c:if test="${habitant.id == projet.habitant.id}">selected</c:if>>${habitant.nom} ${habitant.prenom}</option>
        </c:forEach>
    </select><br><br>

    <!-- Sélection du Domaine -->
    <label for="domaine_id">Domaine :</label>
    <select id="domaine_id" name="domaine_id" required>
        <c:forEach var="domaine" items="${domaines}">
            <option value="${domaine.id}" <c:if test="${domaine.id == projet.domaine.id}">selected</c:if>>${domaine.nom}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">save</button>
</form>
    
</body>
</html>