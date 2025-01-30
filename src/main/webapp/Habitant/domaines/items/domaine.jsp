<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails du Domaine</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .card {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* Shadow pour le carré */
            margin-bottom: 30px;
        }

        h5.card-title {
            font-size: 24px;
            color: #2C3E50;
            font-weight: bold;
            margin-bottom: 10px;
        }

        p.card-text {
            font-size: 16px;
            color: #34495E;
            line-height: 1.6;
            margin: 10px 0;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
            background-color: #3498db;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        .btn:hover {
            background-color: #2980b9;
        }

        .card-text strong {
            color: #2C3E50;
        }

        .back-button {
            margin-top: 30px;
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="card">
            <h5 class="card-title">${domaine.nom}</h5>
            <p class="card-text"><strong>Description :</strong> ${domaine.description}</p>
            <p class="card-text"><strong>Critères :</strong> ${domaine.criteres}</p>
        </div>

        <div class="back-button">
            <a href="${pageContext.request.contextPath}/DomaineHabitant" class="btn btn-secondary">Retour à la liste</a>
        </div>
    </div>

</body>
</html>
