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
    <h5 class="card-title text-primary">${domaine.nom}</h5>
    <p class="card-text"><strong>Description :</strong> ${domaine.description}</p>
    <p class="card-text"><strong>Critères :</strong> ${domaine.criteres}</p>
    </div>
    <a href="${pageContext.request.contextPath}/DomaineHabitant" class="btn btn-secondary">Retour à la liste</a>
</body>
</html>