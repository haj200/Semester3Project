<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Un Habitant</title>
</head>
<body>
<h1>Ajouter Un Habitant</h1>
<form action="HabitantServlet?action=save" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="cin">CIN:</label>
        <input type="text" id="cin" name="cin" required><br><br>

        <label for="addresse">Addresse:</label>
        <input type="text" id="addresse" name="addresse" required><br><br>

        <label for="dateDeNaissance">Date de Naissance (yyyy-mm-dd):</label>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" required><br><br>

        <label for="metier">Metier:</label>
        <input type="text" id="metier" name="metier" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <button type="submit">save</button>
    </form>
</body>
</html>