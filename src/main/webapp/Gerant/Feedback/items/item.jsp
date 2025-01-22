<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="feedback-details" class="feedback section light-background">

    <img
        src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
        alt="">

    <div class="container" data-aos="zoom-out">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card text-black shadow-lg" 
                     style="background: rgba(0, 0, 0, 0.8) url('${pageContext.request.contextPath}/Dist/assetsGerant/img/back.jpg') no-repeat center/cover; position: relative; overflow: hidden; border: none;">
                    <div class="card-body" style="z-index: 1; backdrop-filter: blur(5px);">
                        <h5 class="card-title text-uppercase text-center mb-4">Détails du Feedback</h5>
                        <p class="card-text">
                            <strong>ID :</strong> <c:out value="${feedback.id}" /><br>
                            <strong>Message :</strong> <c:out value="${feedback.message}" /><br>
                            <strong>Proposition :</strong> <c:out value="${feedback.proposition}" /><br>
                            <strong>Projet :</strong> <c:out value="${feedback.projet.titre}" /><br>
                            <strong>Habitant :</strong> <c:out value="${feedback.habitant.nom} ${feedback.habitant.prenom}" /><br>
                        </p>
                    </div>
                    <div class="card-footer d-flex justify-content-between" style="z-index: 1;">
                        <!-- Bouton pour modifier le feedback -->
                        <a href="FeedbackServlet?action=modifier&id=${feedback.id}" class="btn btn-warning btn-sm">Modifier</a>

                        <!-- Bouton pour supprimer le feedback -->
                        <a href="FeedbackServlet?action=supprimer&id=${feedback.id}" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce feedback ?');">Supprimer</a>

                        <!-- Bouton pour revenir à la liste des feedbacks -->
                        <a href="FeedbackServlet" class="btn btn-light btn-sm">Retour</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
