<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">


			<div class="container mt-5">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="card bg-dark text-white shadow-lg">
							<div class="card-header border-0 bg-primary">
								<h5 class="mb-0 text-uppercase text-center">Domaine Details</h5>
							</div>
							<div class="card-body">
								<h6 class="card-title text-muted">Nom:</h6>
								<p class="card-text font-weight-bold">${domaine.nom}</p>

								<h6 class="card-title text-muted">Description:</h6>
								<p class="card-text">${domaine.description}</p>

								<h6 class="card-title text-muted">Critères:</h6>
								<p class="card-text">${domaine.criteres}</p>
							</div>
							<div class="card-footer bg-transparent border-0 text-center">

								<a href="DomaineServlet?action=delete&id=${domaine.id}"
									class="btn btn-outline-danger btn-sm mx-1"
									onclick="return confirm('Voulez-vous vraiment supprimer ce domaine ?');">
									Supprimer </a> <a href="DomaineServlet?action=list"
									class="btn btn-outline-secondary btn-sm mx-1"> Retour à la
									liste </a>
							</div>
						</div>
					</div>
				</div>
			</div>





		</div>

	</div>

</section>
<!-- /Hero Section -->
