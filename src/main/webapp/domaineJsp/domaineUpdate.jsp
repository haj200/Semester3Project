<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>Modifier un Domaine</h1>

<form action="DomaineServlet?action=save&id=${domaine.id}" method="post">
<label for="titre">${domaine.id}</label>
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${domaine.nom}" required><br><br>

    <label for="description">Description :</label>
    <input type="text" id="description" name="description" value="${domaine.description}" required><br><br>

    <label for="criteres">Critères :</label>
    <input type="text" id="criteres" name="criteres" value="${domaine.criteres}" required><br><br>

    <button type="submit">save</button>
</form>
     
</body>
</html>