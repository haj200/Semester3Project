<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Hero Section -->
    <section id="hero" class="hero section dark-background">

      <img src="${pageContext.request.contextPath}/Dist/assetsAdministrateur/img/hero-bg.jpeg" alt="" data-aos="fade-in" class="">

      <div class="container" data-aos="fade-up" data-aos-delay="100">
       <div class="card-body">
  <h4 class="card-title">Réclamations</h4>
  <p class="card-description">
    <code></code>
  </p>
  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
          <th></th>
          <th>Message</th>
          <th>Soumis Par</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="reclamation" items="${reclamations}">
          <tr>
            <td class="py-1">${reclamation.id}</td>
            <td class="py-1">${reclamation.message}</td>
            <td>${reclamation.habitant.nom} ${reclamation.habitant.prenom}</td>
            <td>
             <a href="${pageContext.request.contextPath}/ReclamationAdmin?action=view&id=${reclamation.id}" 
                     class="btn btn-primary btn-sm">
                    voir
                  </a>
              <c:choose>
                <c:when test="${reclamation.est_repondu == 0}">
                  <a href="${pageContext.request.contextPath}/ReclamationAdmin?action=respond&id=${reclamation.id}" 
                     class="btn btn-primary btn-sm">
                    Répondre
                  </a>
                </c:when>
                <c:otherwise>
                  <span class="badge badge-success">Répondu</span>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>

    </section>
