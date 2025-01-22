<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div class="card-body">
    <p class="card-text"><strong>Nom :</strong> ${reclamation.habitant.nom}</p>
<p class="card-text"><strong>Prénom :</strong> ${reclamation.habitant.prenom}</p>
    <p class="card-text"><strong>Message :</strong> ${reclamation.message}</p>
    <p class="card-text"><strong>Reponse :</strong> ${reclamation.reponse}</p>
    </div>
    <a href="${pageContext.request.contextPath}/ReclamationHabitant" class="btn btn-secondary">Retour à la liste</a>
</body>
</html>