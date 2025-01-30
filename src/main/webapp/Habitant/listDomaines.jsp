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
    
   

                            
<div class="container">
    <ul class="list-group">
        <c:forEach var="domaine" items="${domaines}">
            <li class="list-group-item clearfix">
                <!-- Image (ici vous pouvez ajouter l'image pour chaque domaine si nécessaire) -->
                
                
                <!-- Titre du domaine -->
                <h3 class="list-group-item-heading">
                    ${domaine.nom}
                </h3>
                
                <!-- Description du domaine -->
                <p class="list-group-item-text lead">
                    ${domaine.description}
                </p>
                
                <!-- Critères du domaine (vous pouvez ajouter ici selon vos besoins) -->
                
                
                <!-- Lien vers les détails du domaine -->
                <a href="${pageContext.request.contextPath}/DomaineHabitant?action=view&id=${domaine.id}" class="btn btn-default btn-sm">Details</a>
                <a href="${pageContext.request.contextPath}/ProjetHabitant?action=nouveau&id=${domaine.id}" class="btn btn-default btn-sm">Ajouter un projet</a>
                <!-- Lien pour ajouter un projet -->
                
            </li>
        </c:forEach>
    </ul>
</div>

        
        


                    
                    
                    
 </body>             
 <style>
 body 

.list-group {box-shadow: 0px 11px 23px 5px rgba(0,0,0,0.34);}

.list-group-item {background-color: rgba(255,255,255,0.7); border:0;}

.btn-toolbar {margin-top:10px;}


</style>
        

    <!-- jquery
		============================================ -->
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