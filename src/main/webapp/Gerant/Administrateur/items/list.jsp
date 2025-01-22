<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">
			

				<div class="table-responsive">
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Nom</th>
								<th scope="col">Prenom</th>
								<th scope="col">Nom d'utilisateur</th>
								<th scope="col">Email</th>
								<th scope="col" class="text-end">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="admin" items="${admins}">
								<tr>
									<td>${admin.id}</td>
									<td>${admin.nom}</td>
									<td>${admin.prenom}</td>
									<td>${admin.username}</td>
									<td>${admin.email}</td>
									<td class="text-end"><a
										href="AdministrateurServlet?action=modifier&id=${admin.id}"
										class="btn btn-outline-primary btn-sm">Modifier</a> <a
										href="AdministrateurServlet?action=supprimer&id=${admin.id}"
										class="btn btn-outline-danger btn-sm"
										onclick="return confirm('Etes-vous sur de vouloir supprimer cet administrateur ?');">Supprimer</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<nav>
				<ul class="pagination justify-content-center">
					<!-- Lien pour la page précédente -->
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a
							href="AdministrateurServlet?page=${currentPage - 1}" class="page-link"><<
								Avant</a></li>
					</c:if>

					<!-- Liens pour chaque page -->
					<c:forEach var="page" begin="1" end="${totalPages}">
						<li class="page-item ${page == currentPage ? 'active' : ''}">
							<a href="AdministrateurServlet?page=${page}" class="page-link">${page}</a>
						</li>
					</c:forEach>

					<!-- Lien pour la page suivante -->
					<c:if test="${currentPage < totalPages}">
						<li class="page-item"><a
							href="AdministrateurServlet?page=${currentPage + 1}" class="page-link">Suivant
								>></a></li>
					</c:if>
				</ul>
			</nav>
<div class="text-center mt-4">
                    <a href="AdministrateurServlet?action=ajouter" class="btn btn-success">Ajouter un Admin</a>
                </div>
			</div>
		</div>
	

</section>
<!-- /Hero Section -->