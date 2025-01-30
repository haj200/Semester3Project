
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
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Vérifie si l'utilisateur a déjà accepté les conditions
            if (!localStorage.getItem("conditionsAccepted")) {
                var modal = new bootstrap.Modal(document.getElementById("termsModal"));
                modal.show();
            }
        });

        function acceptTerms() {
            localStorage.setItem("conditionsAccepted", "true");
            var modal = bootstrap.Modal.getInstance(document.getElementById("termsModal"));
            modal.hide();
        }
    </script>
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





<a href="DomaineHabitant?action=new" class="add-project-btn">
    <button class="add-project-button">+</button>
</a>
<div class="project-container">
    <table class="project-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Projet</th>
                <th>Description</th>
                <th>Objectifs</th>
                <th>Budget</th>
                <th>Localisation</th>
                <th>Bénéfice</th>
                <th>Est validé</th>
                
                <th>Habitant</th>
                <th>Domaine</th>
                <th>Actions</th>
                 <!-- Nouvelle colonne pour le bouton Feedback -->
            </tr>
        </thead>
        <tbody>
            <!-- Affichage de la liste des projets -->
            <c:forEach var="projet" items="${projects}">
                <tr>
                    <!-- Affichage des informations sur chaque projet -->
                    <td><c:out value="${projet.id}" /></td>
                    <td><c:out value="${projet.titre}" /></td>
                    <td><c:out value="${projet.description}" /></td>
                    <td><c:out value="${projet.objectifs}" /></td>
                    <td><c:out value="${projet.budget}" /></td>
                    <td><c:out value="${projet.localisation}" /></td>
                    <td><c:out value="${projet.benefice}" /></td>
                    <td><c:out value="${projet.estValide}" /></td>
                    
                    <td><c:out value="${projet.habitant.nom} ${projet.habitant.prenom}" /></td>
                    <td><c:out value="${projet.domaine.nom}" /></td>
                    
                    <td>
                        <!-- Bouton pour ajouter un feedback -->
                        <a href="FeedbackHabitant?action=every&idProjet=${projet.id}" class="button">Feedbacks</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
</div>



<style>
.fancy-border-radius-1 {
  border-radius: 29% 71% 56% 44% / 43% 67% 33% 57%;

  width: 330px;
  height: 230px;
  background: #f6c102;
  background: -webkit-linear-gradient(to bottom right,
      #f6c102,
      #ffe496);
  background: linear-gradient(to bottom right,
      #f6c102,
      #ffe496);
}

.fancy-border-radius-2 {
  border-radius: 70% 30% 33% 67% / 27% 66% 34% 73%;

  width: 250px;
  height: 400px;
  background: #f793b3;
  background: -webkit-linear-gradient(to bottom right,
      #f793b3,
      #fcbfd1);
  background: linear-gradient(to bottom right,
      #f793b3,
      #fcbfd1);
}

.fancy-border-radius-3 {
  border-radius: 27% 73% 42% 58% / 71% 74% 26% 29%;

  width: 300px;
  height: 330px;
  background: #76b8cd;
  background: -webkit-linear-gradient(to bottom right,
      #76b8cd,
      #b5def2);
  background: linear-gradient(to bottom right,
      #76b8cd,
      #b5def2);
}
@media (min-width: 1200px) {
  .display-2 {
    font-size: 6.5rem;
  }
}
@media (min-width: 767px) and (max-width: 1199px) {
  .display-2 {
    font-size: 4.5rem;
  }
}
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


/* Style pour la table des projets */
.project-container {
    margin: 20px;
    padding: 10px;
    border-radius: 8px;
    background-color: #f9f9f9;
    position: relative; /* Nécessaire pour positionner correctement le bouton */
}


    .modal {
        display: none; /* Masqué par défaut */
        position: fixed;
        z-index: 1000;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 255, 0.5); /* Arrière-plan semi-transparent bleu */
    }

    .modal-content {
        background-color: white;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 50%;
        text-align: center;
    }

    .close-btn {
        background-color: #2196F3; /* Bleu */
        color: white;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
    }

    .close-btn:hover {
        background-color: #1976D2; /* Bleu foncé au survol */
    }
</style>

<style>
    /* Style pour la table des projets */
    .project-container {
        margin: 20px;
        padding: 10px;
        border-radius: 8px;
        background-color: #f9f9f9;
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

    .delete {
        background-color: #f44336; /* Rouge */
    }

    .delete:hover {
        background-color: #e53935; /* Rouge foncé */
    }
</style>




</div>

<!-- Lien vers la page d'ajout d'un projet -->



            
        </div>
    </div>
</div>
</div>
 <div class="modal fade" id="termsModal" tabindex="-1" aria-labelledby="termsModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="termsModalLabel">Conditions d'Utilisation</h5>
                </div>
                <div class="modal-body">
                    <p>Avant d'accéder à votre tableau de bord, veuillez accepter nos conditions d'utilisation :</p>
                    <ul>
                        <li>Vous acceptez de ne pas partager vos informations personnelles.</li>
                        <li>Vous acceptez de respecter la confidentialité des autres utilisateurs.</li>
                        <li>Toute violation des règles entraînera des sanctions.</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="acceptTerms()">J'accepte</button>
                </div>
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