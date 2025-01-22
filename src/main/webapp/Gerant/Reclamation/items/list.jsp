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
            <th scope="col">Habitant</th>
            <th scope="col" class="text-end"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="reclamation" items="${reclamations}">
            <tr>
                <td>${reclamation.id}</td>
                <td>${reclamation.message}</td>
                <td>${reclamation.habitant.nom} ${reclamation.habitant.prenom}</td>
                <td class="text-end">
                    
                    <a href="ReclamationServlet?action=supprimer&id=${reclamation.id}" 
                       class="btn btn-outline-danger btn-sm" 
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette réclamation ?');">
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>





		</div>

	</div>
</section>