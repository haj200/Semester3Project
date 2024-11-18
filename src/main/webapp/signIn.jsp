<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription Habitant</title>
</head>
<body>
    <h2>Formulaire d'inscription</h2>
	 <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Erreur lors de l'inscription. Veuillez réessayer.</p>
    <% } %>
    <% if (request.getParameter("success") != null) { %>
        <p style="color:green;">Inscription réussie ! Vous pouvez vous connecter.</p>
    <% } %>

    <form action="signin" method="POST">
        <label for="username">Nom d'utilisateur:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="prenom">Prénom:</label><br>
        <input type="text" id="prenom" name="prenom" required><br><br>

        <label for="password">Mot de passe:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <label for="cin">CIN:</label><br>
        <input type="text" id="cin" name="cin" required><br><br>

        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse" required><br><br>

        <label for="dateDeNaissance">Date de naissance:</label><br>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" required><br><br>

        <label for="metier">Métier:</label><br>
        <input type="text" id="metier" name="metier" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>
