<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Dashboard V.1 | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/Dist/assets4/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/owl.theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Dist/assets4/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
<div>
<%@ include file="/temos/HabitantElements/left-sidebar.jsp" %>
    <div class="all-content-wrapper">
    <%@ include file="/temos/HabitantElements/header.jsp" %>
 <div class="single-pro-review-area mt-t-30 mg-b-15">
    <div class="container-fluid">
        <div class="row">
            
<!-- Ajout du CSS pour la stylisation -->



    <header>
    
</header>

<style>
    .page-title {
        text-align: center;
        font-size: 32px; /* Taille de police plus grande */
        color: #2196F3; /* Couleur bleue */
        font-weight: bold; /* Texte en gras */
        margin-top: 20px;
        margin-bottom: 20px;
        text-transform: uppercase; /* Majuscules */
        letter-spacing: 2px; /* Espacement entre les lettres */
        border-bottom: 3px solid #2196F3; /* Ligne sous le titre */
        display: inline-block; /* Permet de centrer avec bordure */
        padding-bottom: 10px; /* Espace sous le texte pour la bordure */
    }
</style>
    
    <main>
        <c:if test="${not empty projects}">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Titre</th>
                        <th>Description</th>
                        <th>Objectifs</th>
                        <th>Budget</th>
                        <th>Localisation</th>
                        <th>Bénéfice</th>
                        <th>Validé</th>
                        
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="projet" items="${projects}">
                        <!-- Vérification si le projet appartient à l'habitant connecté -->
                        <c:if test="${projet.habitant.id == user.id}">
                            <tr>
                                <td>${projet.id}</td>
                                <td>${projet.titre}</td>
                                <td>${projet.description}</td>
                                <td>${projet.objectifs}</td>
                                <td>${projet.budget}</td>
                                <td>${projet.localisation}</td>
                                <td>${projet.benefice}</td>
                                <td>${projet.estValide == 1 ? 'Oui' : 'Non'}</td>
                                
                                
                                
                                <td>
                                    <a href="ProjetHabitant?action=edit&id=${projet.id}">Modifier</a>
                                    <a href="ProjetHabitant?action=delete&id=${projet.id}" 
                                       onclick="return confirm('Voulez-vous vraiment supprimer ce projet ?');">
                                        Supprimer
                                    </a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        
    </main>
    </div>
    </div>
    </div>
    </div>
    </div>
    </body>
    <style>
   
    /* Style pour le tableau */
table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
    font-size: 16px;
    text-align: left;
}

table thead tr {
    background-color: #2196F3; /* Bleu */
    color: white;
    text-align: center;
    font-weight: bold;
}

table th, table td {
    border: 1px solid #ddd;
    padding: 12px;
}

table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tbody tr:hover {
    background-color: #ddd;
}

/* Style des liens dans le tableau */
table a {
    color: #2196F3; /* Bleu */
    text-decoration: none;
    font-weight: bold;
}

table a:hover {
    text-decoration: underline;
}

/* Style du header */
header h1 {
    text-align: center;
    font-size: 24px;
    color: #2196F3; /* Bleu au lieu de vert */
    margin-top: 20px;
}

    
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/jquery.scrollUp.min.js"></script>
    <!-- counterup JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/counterup/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/counterup/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/counterup/counterup-active.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/metisMenu/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/metisMenu/metisMenu-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/morrisjs/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/morrisjs/morris.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/morrisjs/morris-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/sparkline/jquery.charts-sparkline.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/sparkline/sparkline-active.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/calendar/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/calendar/fullcalendar.min.js"></script>
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/calendar/fullcalendar-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/Dist/assets4/js/tawk-chat.js"></script>

    
    </html>
