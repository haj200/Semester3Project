<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un domaine</title>
</head>
<body>
    <h1>Ajouter Un Domaine</h1>
<form action="DomaineServlet?action=save" method="POST">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br><br>

        <label for="criteres">Criteres:</label>
        <input type="text" id="criteres" name="criteres" required><br><br>

        <button type="submit">save</button>
</body>
</html>