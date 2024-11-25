<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h1>Modifier un Habitant</h1>

    <form action="HabitantServlet?action=modifier&id=${habitant.id}" method="post">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" value="${habitant.username}" required><br><br>

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" value="${habitant.nom}" required><br><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" value="${habitant.prenom}" required><br><br>

        <label for="email">Email :</label>
        <input type="email" id="email" name="email" value="${habitant.email}" required><br><br>

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" value="${habitant.password}" required><br><br>

        <label for="cin">CIN :</label>
        <input type="text" id="cin" name="cin" value="${habitant.cin}" required><br><br>

        <label for="addresse">Adresse :</label>
        <input type="text" id="addresse" name="addresse" value="${habitant.addresse}" required><br><br>

        <label for="dateDeNaissance">Date de naissance :</label>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" value="${habitant.dateDeNaissance}" required><br><br>

        <label for="metier">Métier :</label>
        <input type="text" id="metier" name="metier" value="${habitant.metier}" required><br><br>

        <button type="submit">save</button>
    </form>

    
</body>
</html>