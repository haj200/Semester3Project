<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card text-black shadow-lg" 
                 style="background: rgba(0, 0, 0, 0.8) url('${pageContext.request.contextPath}/Dist/assetsGerant/img/back.jpg') no-repeat center/cover; position: relative; overflow: hidden; border: none;">
                <div class="card-body" style="z-index: 1; backdrop-filter: blur(5px);">
                    <h5 class="card-title text-uppercase text-center mb-4">Détails du Projet</h5>
                    <p class="card-text">
                        <strong>ID:</strong> <c:out value="${projet.id}" /><br>
                        <strong>Titre:</strong> <c:out value="${projet.titre}" /><br>
                        <strong>Description:</strong> <c:out value="${projet.description}" /><br>
                        <strong>Objectifs:</strong> <c:out value="${projet.objectifs}" /><br>
                        <strong>Budget:</strong> <c:out value="${projet.budget}" /><br>
                        <strong>Localisation:</strong> <c:out value="${projet.localisation}" /><br>
                        <strong>Bénéfice:</strong> <c:out value="${projet.benefice}" /><br>
                        <strong>Est validé:</strong> <c:out value="${projet.estValide}" /><br>
                        <strong>Gain:</strong> <c:out value="${projet.gain}" /><br>
                        <strong>Habitant:</strong> <c:out value="${projet.habitant.nom} ${projet.habitant.prenom}" /><br>
                        <strong>Domaine:</strong> <c:out value="${projet.domaine.nom}" /><br>
                    </p>
                </div>
                <div class="card-footer d-flex justify-content-between" style="z-index: 1;">
                    
                    <a href="ProjectServlet?action=delete&id=${projet.id}" class="btn btn-danger btn-sm" 
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce projet ?');">
                        Supprimer
                    </a>
                     <a href="ProjectServlet" class="btn btn-light btn-sm" 
                       >
                       retour
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</section>
