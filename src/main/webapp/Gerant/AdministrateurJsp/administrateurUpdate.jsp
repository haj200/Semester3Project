<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un admin</title>
</head>
<body>
<h1>Modifier Un Admin</h1>
<form action="AdministrateurServlet?action=save&id=${admin.id}" method="POST">

        <label for="titre">${admin.id}</label>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="${admin.nom}" required><br><br>
        
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" value="${admin.prenom}" required ><br><br>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${admin.username}" required ><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${admin.email}" required ><br><br>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="${admin.password}" required ><br><br>

        <button type="submit">save</button>
        </form>
</body>
</html>