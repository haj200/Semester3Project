<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">



			<div class="portfolio-details-slider swiper init-swiper">
				<script type="application/json" class="swiper-config">
            {
              "loop": true,
              "speed": 600,
              "autoplay": {
                "delay": 5000
              },
              "slidesPerView": "auto",
              "navigation": {
                "nextEl": ".swiper-button-next",
                "prevEl": ".swiper-button-prev"
              },
              "pagination": {
                "el": ".swiper-pagination",
                "type": "bullets",
                "clickable": true
              }
            }
          </script>
				<div class="swiper-wrapper align-items-center">
					<c:forEach var="projet" items="${projects}">
						<!-- Affichage des informations sur chaque projet -->
						<div class="swiper-slide">
							<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card text-black shadow-lg" style="background: rgba(0, 0, 0, 0.8) url('${pageContext.request.contextPath}/Dist/assetsGerant/img/back.jpg') no-repeat center/cover; position: relative; overflow: hidden; border: none;">
                
                
                <div class="card-body" style="z-index: 1;">
                   <p class="card-text" style="margin:10px; padding: 20px; border-radius: 10px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); border: 1px solid #E0E0E0;">
    Le projet <strong style="color: #8B0000;">"<c:out value="${projet.titre}" />"</strong> 
    (ID: <span style="color: #4D4D4D;"><c:out value="${projet.id}" /></span>) 
    est un effort ambitieux visant à 
    <strong style="color: #2E2E2E;"><c:out value="${projet.objectifs}" /></strong>. 
    Situé à <strong style="color: #7A3D3D;"><c:out value="${projet.localisation}" /></strong>, ce projet se concentre sur 
    <strong style="color: #4D4D4D;"><c:out value="${projet.description}" /></strong>, 
    avec un budget alloué de <strong style="color: #5A5A5A;"><c:out value="${projet.budget}" /> dirhams</strong>. 
    Une fois réalisé, il devrait générer un bénéfice estimé à 
    <strong style="color: #6A1B1B;"><c:out value="${projet.benefice}" /> dirhams</strong>, 
    avec un gain direct de <strong style="color: #A52A2A;"><c:out value="${projet.gain}" /> dirhams</strong>. 
    Ce projet, actuellement <strong style="color: #990000;"><c:out value="${projet.estValide}" /></strong>, 
    est associé à l'habitant <strong style="color: #5C5C5C;"><c:out value="${projet.habitant.nom} ${projet.habitant.prenom}" /></strong>, 
    et opère dans le domaine <strong style="color: #8B0000;"><c:out value="${projet.domaine.nom}" /></strong>. 
    Ces éléments combinés font de ce projet une initiative clé pour le développement local.
</p>
                <div class="card-footer d-flex justify-content-between" style="z-index: 1;">
                    
                    
                    <a href="ProjectServlet?action=view&id=${projet.id}" class="btn btn-dark " 
                       >
                        voir
                    </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

							
						</div>
					</c:forEach>
					</div>
<div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
          <div class="swiper-pagination"></div>
          
           </div>



				</div>

			</div>
</section>
<!-- /Hero Section -->
<div class="container my-4" data-aos="zoom-out">
    <div class="row justify-content-center">
        <div class="table-responsive">
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Titre</th>
                        <th scope="col">Budget</th>
                        <th scope="col">Localisation</th>
                        <th scope="col" class="text-end"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="projet" items="${projects}">
                        <tr>
                            <td>${projet.id}</td>
                            <td>${projet.titre}</td>
                            <td>${projet.budget}</td>
                            <td>${projet.localisation}</td>
                            <td class="text-end">
                                <a href="ProjectServlet?action=view&id=${projet.id}" class="btn btn-dark " 
                       >
                        voir
                    </a>
                                <a href="ProjectServlet?action=delete&id=${projet.id}" 
                                   class="btn btn-outline-danger btn-sm" 
                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce projet ?');">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>








