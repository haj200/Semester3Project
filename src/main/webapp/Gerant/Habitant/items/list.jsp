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
						<th scope="col">Nom</th>
						<th scope="col">Username</th>
						<th scope="col">Prénom</th>
						<th scope="col">Email</th>
						<th scope="col">CIN</th>
						<th scope="col">Adresse</th>
						<th scope="col">Date de Naissance</th>
						<th scope="col">Métier</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="habitant" items="${habitants}">
						<tr>
							<td><c:out value="${habitant.nom}" /></td>
							<td><c:out value="${habitant.username}" /></td>
							<td><c:out value="${habitant.prenom}" /></td>
							<td><c:out value="${habitant.email}" /></td>
							<td><c:out value="${habitant.cin}" /></td>
							<td><c:out value="${habitant.addresse}" /></td>
							<td><c:out value="${habitant.dateDeNaissance}" /></td>
							<td><c:out value="${habitant.metier}" /></td>
							<td class="text-center">
								<!-- Boutons pour modifier et supprimer l'habitant --> <a
								href="HabitantServlet?action=modifier&id=${habitant.id}"
								class="btn btn-warning">Modifier</a> <a
								href="HabitantServlet?action=supprimer&id=${habitant.id}"
								class="btn btn-danger"
								onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet habitant ?');">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav>
  <ul class="pagination justify-content-center">
    <!-- Lien pour la page précédente -->
    <c:if test="${currentPage > 1}">
      <li class="page-item">
        <a href="HabitantServlet?page=${currentPage - 1}"
							class="page-link"><< Avant</a>
						</li>
    </c:if>

    <!-- Liens pour chaque page -->
    <c:forEach var="page" begin="1" end="${totalPages}">
      <li class="page-item ${page == currentPage ? 'active' : ''}">
        <a href="HabitantServlet?page=${page}" class="page-link">${page}</a>
      </li>
    </c:forEach>

    <!-- Lien pour la page suivante -->
    <c:if test="${currentPage < totalPages}">
      <li class="page-item">
        <a href="HabitantServlet?page=${currentPage + 1}" class="page-link">Suivant >></a>
      </li>
    </c:if>
  </ul>
</nav>
<div class="text-center mt-4">
                    <a href="HabitantServlet?action=ajouter" class="btn btn-success">Ajouter un Habitant</a>
                </div>





		</div>

	</div>
	
</section>
<!-- /Hero Section -->
