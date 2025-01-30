<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">


			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nom</th>
						<th scope="col">Description</th>
						
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="domaine" items="${domaines}">
						<tr>
							<td><c:out value="${domaine.id}" /></td>
							<td><c:out value="${domaine.nom}" /></td>
							<td><c:out value="${domaine.description}" /></td>
							
							<td >
								<!-- Boutons pour modifier et supprimer le domaine --> <a
								href="DomaineServlet?action=modifier&id=${domaine.id}"
								class="btn btn-warning btn-sm">Modifier</a>
								<a
								href="DomaineServlet?action=view&id=${domaine.id}"
								class="btn btn-info btn-sm">voir</a>
								 <a
								href="DomaineServlet?action=supprimer&id=${domaine.id}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce domaine ?');">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- Pagination -->
			<nav>
				<ul class="pagination justify-content-center">
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a
							href="DomaineServlet?page=${currentPage - 1}" class="page-link"><<
								Avant</a></li>
					</c:if>
					<c:forEach var="page" begin="1" end="${totalPages}">
						<li class="page-item ${page == currentPage ? 'active' : ''}">
							<a href="DomaineServlet?page=${page}" class="page-link">${page}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage < totalPages}">
						<li class="page-item"><a
							href="DomaineServlet?page=${currentPage + 1}" class="page-link">Suivant
								>></a></li>
					</c:if>
				</ul>
			</nav>

			<!-- Bouton pour ajouter un domaine -->
			<div class="text-center mt-4">
				<a href="DomaineServlet?action=ajouter" class="btn btn-success">Ajouter
					un Domaine</a>
			</div>





		</div>

	</div>

</section>
<!-- /Hero Section -->
