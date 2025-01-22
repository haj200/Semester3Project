
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Hero Section -->
<section id="hero" class="hero section dark-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg"
		alt="" data-aos="fade-in" class="">
	<div class="container" data-aos="fade-up" data-aos-delay="100">
		<div class="portfolio-details-slider swiper init-swiper">

			<script type="application/json" class="swiper-config">
                {
                  "loop": true,
                  "speed": 600,
                  "autoplay": {
                    "delay": 5000
                  },
                  "slidesPerView": "auto",
                  "pagination": {
                    "el": ".swiper-pagination",
                    "type": "bullets",
                    "clickable": true
                  }
                }
              </script>

			<div class="swiper-wrapper align-items-center">


				<c:forEach var="projet" items="${projets}">
					<div class="swiper-slide">
						<!-- Project Card -->
						<div class="card">

							<div class="card-body">
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

								<div class="d-flex justify-content-end">
									<a href="#" class="btn btn-success btn-sm mx-2">Télécharger
										Documents</a> <a
										href="${pageContext.request.contextPath}/ProjetAdmin?action=view&id=${projet.id}"
										class="btn btn-primary btn-sm mx-2"> Voir </a>
									<c:choose>
										<c:when test="${projet.estValide == 0}">
											<a
												href="${pageContext.request.contextPath}/ProjetAdmin?action=validate&id=${projet.id}&est_valide=1"
												class="btn btn-info btn-sm mx-2">Valider</a>
											<a
												href="${pageContext.request.contextPath}/ProjetAdmin?action=validate&id=${projet.id}&est_valide=-1"
												class="btn btn-danger btn-sm mx-2">Non Valider</a>
										</c:when>
										<c:when test="${projet.estValide == 1}">
											<span class="badge bg-success">Validé</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-danger">Non Validé</span>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="swiper-pagination"></div>
		</div>

	</div>

</section>
<section id="portfolio-details" class="portfolio-details section">

	<div class="container" data-aos="fade-up" data-aos-delay="100">
		<div class="card-body">
			<h4 class="card-title">Projets</h4>
			<p class="card-description">
				<code></code>
			</p>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Titre</th>
							<th>Domaine</th>
							<th>Description</th>
							<th>Objectifs</th>
							<th>Budget</th>
							<th>Localisation</th>
							<th>Proposé par</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="projet" items="${projets}">
							<tr>
								<td class="py-1">${projet.id}</td>
								<td class="py-1">${projet.titre}</td>
								<td>${projet.domaine.nom}</td>
								<td>${projet.description}</td>
								<td>${projet.objectifs}</td>
								<td>${projet.budget}</td>
								<td>${projet.localisation}</td>
								<td>${projet.habitant.nom}${projet.habitant.prenom}</td>
								<td><a
									href="${pageContext.request.contextPath}/ProjetAdmin?action=view&id=${projet.id}"
									class="btn btn-primary btn-sm"> Voir </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>
