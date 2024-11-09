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
hello

    <h1>  list habitants </h1>
    <c:forEach var="habitant" items="${habitants}">
        
            <!-- Affichage de l'article -->
            <c:out value="${habitant.nom}" />
            <c:out value="${habitant.email}" />

</c:forEach>  
</body>
</html>