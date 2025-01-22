<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="hero" class="hero section light-background">

	<img
		src="${pageContext.request.contextPath}/Dist/assetsGerant/img/hero-bg.png"
		alt="">

	<div class="container" data-aos="zoom-out">
		<div class="row justify-content-center">



			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Message</th>
						<th scope="col">Proposition</th>
						<th scope="col">Projet</th>
						<th scope="col">Habitant</th>
						<th scope="col" class="text-end"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="feedback" items="${feedbacks}">
						<tr>
							<td>${feedback.id}</td>
							<td>${feedback.message}</td>
							<td>${feedback.proposition}</td>
							<td>${feedback.projet.titre}</td>
							<td>${feedback.habitant.nom}${feedback.habitant.prenom}</td>
							<td class="text-end">  <a
								href="FeedbackServlet?action=supprimer&id=${feedback.id}"
								class="btn btn-outline-danger btn-sm"
								onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce feedback ?');">
									Supprimer </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>




		</div>

	</div>
</section>