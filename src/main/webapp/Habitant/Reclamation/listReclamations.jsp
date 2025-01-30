
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
<%@ include file="/temos/HabitantElements/left-sidebar.jsp" %>
    <div class="all-content-wrapper">
    <%@ include file="/temos/HabitantElements/header.jsp" %>
 <div class="single-pro-review-area mt-t-30 mg-b-15">
    <div class="container-fluid">
        <div class="row">
            
<!-- Ajout du CSS pour la stylisation -->





  
<a href="ReclamationHabitant?action=new" class="add-project-btn">
    <button class="add-project-button">+</button>
</a>
<div class="project-container">
    <table class="project-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Message</th>
                <th>Réponse</th>
                <th>Habitant</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <!-- Affichage de la liste des réclamations -->
            <c:forEach var="reclamation" items="${reclamations}">
                <tr>
                    <!-- Affichage des informations sur chaque réclamation -->
                    <td><c:out value="${reclamation.id}" /></td>
                    <td><c:out value="${reclamation.message}" /></td>
                    <td><c:out value="${reclamation.reponse}" /></td>
                    <td><c:out value="${reclamation.habitant.nom} ${reclamation.habitant.prenom}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/ReclamationHabitant?action=view&id=${reclamation.id}" class="button">Voir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



    <style>
    /* Style du bouton circulaire */
.add-project-btn {
    position: relative;
    display: flex;
    justify-content: flex-start; /* Toujours aligné à gauche */
    margin-top: 20px; /* Espace entre la table et le bouton */
    margin-left: 20px; /* Ajouter un léger décalage vers la droite */
}

.add-project-button {
    width: 50px;  /* Largeur du bouton */
    height: 50px; /* Hauteur du bouton */
    border-radius: 50%; /* Bordures arrondies pour créer un cercle */
    background-color: #2196F3; /* Couleur bleue */
    color: white;
    font-size: 30px; /* Taille du "+" */
    border: none;
    cursor: pointer;
    text-align: center;
    line-height: 50px; /* Centrer le "+" dans le cercle */
    display: flex;
    align-items: center;
    justify-content: center;
}

.add-project-button:hover {
    background-color: #1976D2; /* Bleu foncé au survol */
}
/* Style pour la table des réclamations */
.project-container {
    margin: 20px;
    padding: 10px;
    border-radius: 8px;
    background-color: #f9f9f9;
    position: relative; /* Nécessaire pour positionner correctement le bouton */
}

.project-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.project-table th,
.project-table td {
    padding: 12px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.project-table th {
    background-color: #2196F3; /* Bleu */
    color: white;
    font-weight: bold;
}

.project-table tr:nth-child(even) {
    background-color: #e3f2fd; /* Bleu clair */
}

.project-table tr:hover {
    background-color: #bbdefb; /* Bleu au survol */
}

/* Style pour les boutons */
.button {
    padding: 8px 16px;
    margin: 4px;
    border: none;
    background-color: #2196F3; /* Bleu */
    color: white;
    text-decoration: none;
    border-radius: 4px;
}

.button:hover {
    background-color: #1976D2; /* Bleu foncé au survol */
}

.add-project-btn {
    position: relative;
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

</style>
    
</div>





<!-- Lien vers la page d'ajout d'un projet -->



            
        </div>
    </div>
</div>

        
</body>
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


